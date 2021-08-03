package org.bytecamp.program_repair.backend.server

import AstorInputConfig
import org.bytecamp.program_repair.backend.grpc.RepairTaskRequest
import org.bytecamp.program_repair.backend.grpc.RepairTaskResponse
import java.io.File
import java.io.PrintStream


class AstorRepairServer : RepairServer {
    override fun submitTask(source: String, task: RepairTaskRequest): RunningRepairTask {
        return AstorRepairTask(source, task)
    }
}

class AstorRepairTask(source: String, val task: RepairTaskRequest) : RunningRepairTask {
    private val source = File(source)


    override fun execute(writer: PrintStream): RepairTaskResponse {
        val config = getConfig(writer)
        val arguments: String = config.toArgs().joinToString(" ")
        val child = Runtime.getRuntime().exec("java -cp build/astor.jar fr.inria.main.evolution.AstorMain $arguments")
        val out = child.inputStream
        val buffer = ByteArray(1000)
        while (true) {
            val len = out.read(buffer);
            if (len < 0)
                break
            writer.print(buffer.slice(IntRange(0, len)))
        }
        child.waitFor()
        val respBuilder = RepairTaskResponse.newBuilder()
        val outConfig = config.getOutConfig()
        for (patch in outConfig.patches) {
            for (hunk in patch.patchhunks) {
                val builder = RepairTaskResponse.Patch.newBuilder()
                builder.modified = File(hunk.getModifiedFilePath()).readText(Charsets.UTF_8)
                builder.success = true
                builder.sourcePath = hunk.getPath()
                respBuilder.addPatch(builder.build())

            }
        }
        return respBuilder.build()
    }

    fun getCommonPackage(file: File, prefix: String): String {

        return if (file.isDirectory) {
            val files = file.listFiles()!!
            if (files.size > 1) {
                if (prefix.isEmpty()) {
                    file.name
                } else {
                    prefix + "." + file.name
                }
            } else if (files.isEmpty()) {
                prefix
            } else {
                if (file.name == "java") {
                    getCommonPackage(files[0], prefix)
                } else if (prefix.isEmpty()) {
                    getCommonPackage(files[0], file.name)
                } else {
                    getCommonPackage(files[0], prefix + "." + file.name)
                }
            }
        } else {
            prefix
        }
    }

    fun getBuildSystem(): String {
        val system = if (File(source, "build.gradle").exists() || File(source, "build.gradle.kts").exists()) {
            "gradle"
        } else if (File(source, "pom.xml").exists()) {
            "maven"
        } else {
            "others"
        }
        return system
    }

    fun getConfig(writer: PrintStream): AstorInputConfig {
        val config = AstorInputConfig()
        config.location = source.path
        config.projectName = source.name
        config.src = File(source, "src/main/java").path
        config.pkg = getCommonPackage(File(source, "src/main/java"), "")
        config.srcTest = File(source, "src/test/java").path

        val base = source.path
        when (getBuildSystem()) {
            "gradle" -> {
                config.bin = "$base/build/classes/java/main"
                config.binTest = "$base/build/classes/java/test"
                config.out = "$base/build/astor"
            }
            "maven" -> {
                config.bin = "$base/target/classes"
                config.binTest = "$base/target/test-classes"
                config.out = "$base/target/astor"
            }
            else -> {
                writer.println("Does not support build systems other than gradle or maven")
            }
        }
        return config
    }
}

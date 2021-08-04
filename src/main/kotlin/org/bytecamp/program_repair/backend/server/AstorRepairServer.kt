package org.bytecamp.program_repair.backend.server

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.bytecamp.program_repair.backend.configs.AstorInputConfig
import org.bytecamp.program_repair.backend.grpc.RepairTaskRequest
import org.bytecamp.program_repair.backend.grpc.RepairTaskResponse
import org.bytecamp.program_repair.backend.grpc.RepairTaskResult
import java.io.File
import java.io.PrintStream


class AstorRepairServer : RepairServer {
    override fun submitTask(source: String, task: RepairTaskRequest): RunningRepairTask {
        return AstorRepairTask(source, task)
    }
}

class AstorRepairTask(source: String, val task: RepairTaskRequest) : RunningRepairTask {
    private val logger: Logger = LogManager.getLogger()

    private val source = File(source)


    override fun execute(writer: PrintStream): RepairTaskResponse {
        val config = getConfig(writer)
        config.mode = task.algorithm

        val arguments: String = config.toArgs().joinToString(" ")
        val realCmd = "java -cp build/astor.jar fr.inria.main.evolution.AstorMain $arguments"
        logger.info("Running $realCmd")
        val child = Runtime.getRuntime().exec(realCmd)
        val out = child.inputStream
        val out2 = child.errorStream
        val buf = ByteArray(100000)
        while (child.isAlive) {

            while (out.available() > 0) {
                val bytes = out.read(buf)
                if (bytes < 0)
                    break
                writer.print(String(buf, 0, bytes))
            }
            while (out2.available() > 0) {
                val bytes = out2.read(buf)
                if (bytes < 0)
                    break
                writer.print(String(buf, 0, bytes))
            }

        }

        // build the successful result
        val outConfig = config.getOutConfig()
        val resultBuilder = RepairTaskResult.newBuilder()
        resultBuilder.success = true
        for (patch in outConfig.patches) {
            for (hunk in patch.patchhunks) {
                val builder = RepairTaskResult.Patch.newBuilder()
                builder.modified = File(hunk.getModifiedFilePath()).readText(Charsets.UTF_8)
                builder.sourcePath = File(hunk.getPath()).relativeTo(source).path
                resultBuilder.addPatch(builder.build())
            }
        }

        val respBuilder = RepairTaskResponse.newBuilder()
        respBuilder.frameType = RepairTaskResponse.FrameType.RESULT
        respBuilder.addResult(resultBuilder.build())
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
        config.out = "build/astor"

        val base = source.path
        when (getBuildSystem()) {
            "gradle" -> {
                config.bin = "$base/build/classes/java/main"
                config.binTest = "$base/build/classes/java/test"
            }
            "maven" -> {
                config.bin = "$base/target/classes"
                config.binTest = "$base/target/test-classes"
            }
            else -> {
                writer.println("Does not support build systems other than gradle or maven")
            }
        }
        return config
    }
}

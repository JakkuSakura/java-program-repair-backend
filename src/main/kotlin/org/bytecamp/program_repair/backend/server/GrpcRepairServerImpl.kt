package org.bytecamp.program_repair.backend.server

import io.grpc.stub.StreamObserver
import org.apache.logging.log4j.LogManager
import org.bytecamp.program_repair.backend.grpc.RepairServerGrpc.RepairServerImplBase
import org.bytecamp.program_repair.backend.grpc.RepairTaskRequest
import org.bytecamp.program_repair.backend.grpc.RepairTaskResponse
import org.bytecamp.program_repair.backend.utils.*
import java.io.ByteArrayInputStream
import java.io.File
import java.io.PrintStream
import java.util.*
import kotlin.concurrent.thread
import kotlin.math.abs


class GrpcRepairServerImpl(val server: RepairServer) : RepairServerImplBase() {
    private val logger = LogManager.getLogger()
    private val random = Random()
    private fun prepareProject(type: RepairTaskRequest.LocationType, projectName: String, location: String?, content: ByteArray?): String {
        when (type) {
            RepairTaskRequest.LocationType.PATH -> {
                return location!!
            }
            RepairTaskRequest.LocationType.GIT -> {
                val rnd = abs(random.nextInt())
                val path = "git_repo/$projectName-$rnd/"
                File(path).mkdirs()
                val child = Runtime.getRuntime().exec("sh -c 'cd \"$path/../\" && git clone $location $projectName-$rnd --recursive'")
                child.waitFor()
                return path
            }
            RepairTaskRequest.LocationType.ZIP -> {
                val rnd = abs(random.nextInt())
                val path = "zip_repo/$projectName-$rnd/"
                File(path).mkdirs()
                ZipManager.unzip(ByteArrayInputStream(content!!), File(path))
                return path
            }
            else -> {
                throw IllegalArgumentException("Does not support $type")
            }
        }
    }

    override fun submitTask(
        request: RepairTaskRequest?,
        responseObserver: StreamObserver<RepairTaskResponse?>?
    ) {
        thread {
            val path = prepareProject(request!!.locationType, request.project, request.location, request.content.toByteArray())
            val running = server.submitTask(path, request)
            val printer = newPrintStream(responseObserver!!)
            try {
                val config = running.execute(printer)
                responseObserver.onNext(config)
            } catch (e: Exception) {
                logger.error(e)
                val err = e.stackTraceToString()
                val builder =
                    RepairTaskResponse.newBuilder().setFrameType(RepairTaskResponse.FrameType.RESULT).setMessage(err)
                responseObserver.onNext(builder.build())
            }
            responseObserver.onCompleted()
        }
    }


}

fun newPrintStream(responseObserver: StreamObserver<RepairTaskResponse?>): PrintStream {
    val writer = FanOutWriter()
    writer.add(ExecuteResponseWriter(responseObserver))
    writer.add(LogWriter(LogManager.getLogger()))
    return PrintStream(WriterStream(writer))
}

class ExecuteResponseWriter(var observer: StreamObserver<RepairTaskResponse?>) : IWriter {
    override fun write(chunk: String) {
        observer.onNext(
            RepairTaskResponse.newBuilder().setFrameType(RepairTaskResponse.FrameType.STDOUT).setMessage(chunk).build()
        )
    }
}
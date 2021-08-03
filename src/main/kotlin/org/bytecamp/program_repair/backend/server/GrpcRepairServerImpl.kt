package org.bytecamp.program_repair.backend.server

import io.grpc.stub.StreamObserver
import org.apache.logging.log4j.LogManager
import org.bytecamp.program_repair.backend.grpc.*
import org.bytecamp.program_repair.backend.grpc.RepairServerGrpc.RepairServerImplBase
import org.bytecamp.program_repair.backend.utils.*
import java.io.PrintStream
import java.lang.Exception
import java.util.*
import kotlin.concurrent.thread
import kotlin.math.abs
import kotlin.math.log


class GrpcRepairServerImpl(val server: RepairServer) : RepairServerImplBase() {
    private val logger = LogManager.getLogger()
    private val random = Random()
    private fun prepareProject(type: RepairTaskRequest.LocationType, location: String): String {
        when (type) {
            RepairTaskRequest.LocationType.PATH -> {
                return location
            }
            RepairTaskRequest.LocationType.GIT -> {
                val rnd = abs(random.nextInt())
                val path = "git_repo/$rnd/"

                val child = Runtime.getRuntime().exec("sh -c 'cd \"$path\" && git clone $location --recursive'")
                child.waitFor()
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
            val path = prepareProject(request!!.locationType, request.location)
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
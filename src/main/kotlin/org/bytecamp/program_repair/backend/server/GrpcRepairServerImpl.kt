package org.bytecamp.program_repair.backend.server

import io.grpc.stub.StreamObserver
import org.bytecamp.program_repair.backend.grpc.*
import org.bytecamp.program_repair.backend.grpc.RepairServerGrpc.RepairServerImplBase
import org.bytecamp.program_repair.backend.utils.DupWriter
import org.bytecamp.program_repair.backend.utils.IWriter
import org.bytecamp.program_repair.backend.utils.WriterStream
import java.io.*
import java.util.*
import kotlin.concurrent.thread
import kotlin.math.abs


class GrpcRepairServerImpl(val server: RepairServer) : RepairServerImplBase() {
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
            val config = running.execute(newPrintStream(responseObserver!!))
            responseObserver.onNext(config)
        }
    }


}

fun newPrintStream(responseObserver: StreamObserver<RepairTaskResponse?>): PrintStream {
    val writer = DupWriter()
    writer.add(ExecuteResponseWriter(responseObserver))
    return PrintStream(WriterStream(writer))
}

class ExecuteResponseWriter(var observer: StreamObserver<RepairTaskResponse?>) : IWriter {
    override fun write(chunk: String) {
        observer.onNext(
            RepairTaskResponse.newBuilder().setFrameType(RepairTaskResponse.FrameType.STDOUT).setMessage(chunk).build()
        )
    }
}
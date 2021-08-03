package org.bytecamp.program_repair.backend

import io.grpc.Server
import io.grpc.ServerBuilder
import org.bytecamp.program_repair.backend.server.AstorRepairServer
import org.bytecamp.program_repair.backend.server.GrpcRepairServerImpl

class RepairServerMain {

    private val server: Server =
        ServerBuilder.forPort(10000).addService(GrpcRepairServerImpl(AstorRepairServer())).build()

    fun start() {
        server.start()
        System.err.println("Server started, listening on 10000 ")
        Runtime.getRuntime().addShutdownHook(Thread {

            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC org.bytecamp.program_repair.backend.server since JVM is shutting down")
            stop()
            System.err.println("*** org.bytecamp.program_repair.backend.server shut down")
        })
    }

    fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

}

fun main(args: Array<String>) {
    val server = RepairServerMain()
    server.start()
    server.blockUntilShutdown()
}
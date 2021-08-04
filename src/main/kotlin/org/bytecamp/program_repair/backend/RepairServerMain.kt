package org.bytecamp.program_repair.backend

import io.grpc.Server
import io.grpc.ServerBuilder
import org.bytecamp.program_repair.backend.server.AstorRepairServer
import org.bytecamp.program_repair.backend.server.GrpcRepairServerImpl

class RepairServerMain(val port: Int) {

    private val server: Server =
        ServerBuilder.forPort(port).addService(GrpcRepairServerImpl(AstorRepairServer())).build()

    fun start() {
        server.start()
        System.err.println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(Thread {

            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down server since JVM is shutting down")
            stop()
            System.err.println("*** server shut down")
        })
    }

    fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var port = 10000
            for (i in args.indices) {
                if (i < args.size && args[i] == "--port") {
                    port = args[i + 1].toInt()
                }
            }

            val server = RepairServerMain(port)
            server.start()
            server.blockUntilShutdown()
        }
    }
}


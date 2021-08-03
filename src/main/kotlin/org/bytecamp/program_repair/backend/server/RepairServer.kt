package org.bytecamp.program_repair.backend.server

import org.bytecamp.program_repair.backend.grpc.RepairTaskRequest
import org.bytecamp.program_repair.backend.grpc.RepairTaskResponse
import java.io.PrintStream

interface RunningRepairTask {
    fun execute(writer: PrintStream): RepairTaskResponse
}

interface RepairServer {
    fun submitTask(source: String, task: RepairTaskRequest): RunningRepairTask
}
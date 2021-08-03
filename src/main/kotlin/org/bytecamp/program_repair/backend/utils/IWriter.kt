package org.bytecamp.program_repair.backend.utils

interface IWriter {
    fun write(chunk: String)
    fun writeln(line: String) {
        write(line + "\n")
    }
}
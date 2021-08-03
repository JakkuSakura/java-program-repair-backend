package org.bytecamp.program_repair.backend.utils

class FanOutWriter : IWriter {
    var writers = ArrayList<IWriter>()
    fun add(writer: IWriter) {
        writers.add(writer)
    }

    override fun write(chunk: String) {
        for (writer in writers) {
            writer.write(chunk)
        }
    }

    override fun writeln(line: String) {
        for (writer in writers) {
            writer.writeln(line)
        }
    }
}
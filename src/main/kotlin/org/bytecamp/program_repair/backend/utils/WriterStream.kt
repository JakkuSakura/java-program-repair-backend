package org.bytecamp.program_repair.backend.utils

import java.io.IOException
import java.io.OutputStream

class WriterStream(private val writer: IWriter) : OutputStream() {
    private val buffer = StringBuffer()
    @Throws(IOException::class)
    override fun write(b: Int) {
        if (b == '\n'.toInt()) {
            flush()
            return
        }
        if (buffer.length > 300) {
            writer.write(buffer.toString())
            buffer.setLength(0)
        }
        buffer.append(b)
    }

    @Throws(IOException::class)
    override fun write(b: ByteArray) {
        flush()
        writer.write(String(b, Charsets.UTF_8))
    }

    @Throws(IOException::class)
    override fun write(b: ByteArray, off: Int, len: Int) {
        if (off < 0 || off > b.size || len < 0 ||
            off + len > b.size || off + len < 0
        ) {
            throw IndexOutOfBoundsException()
        } else if (len == 0) {
            return
        }
        flush()
        writer.write(String(b.copyOfRange(off, off + len), Charsets.UTF_8))
    }

    @Throws(IOException::class)
    override fun flush() {
        if (buffer.isNotEmpty()) {
            writer.write(buffer.toString())
            buffer.setLength(0)
        }
    }

    @Throws(IOException::class)
    override fun close() {
        flush()
    }
}
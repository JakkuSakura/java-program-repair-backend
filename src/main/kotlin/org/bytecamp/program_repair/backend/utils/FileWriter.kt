package org.bytecamp.program_repair.backend.utils

import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.Writer

class FileWriter(file: File) : IWriter {
    private val file: Writer
    override fun write(chunk: String) {
        try {
            file.write(chunk)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    init {
        this.file = FileWriter(file)
    }
}
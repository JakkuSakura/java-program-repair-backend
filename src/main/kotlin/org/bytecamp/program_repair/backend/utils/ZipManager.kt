package org.bytecamp.program_repair.backend.utils

import java.io.*
import java.util.function.BiConsumer
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream


object ZipManager {
    fun unzip(
        inputStream: InputStream, baseDir: File
    ) {
        ZipInputStream(inputStream).use { zipInput ->
            var entry: ZipEntry?
            while (zipInput.nextEntry.also { entry = it } != null) {
                val file = File(baseDir, entry!!.name)
                if (entry!!.isDirectory) {
                    file.mkdirs()
                } else {
                    val buffer = ByteArray(1024)
                    var length: Int
                    file.parentFile.mkdirs()
                    val outStream = BufferedOutputStream(FileOutputStream(file))
                    while (zipInput.read(buffer).also { length = it } != -1) {
                        outStream.write(buffer, 0, length)
                    }
                    outStream.close()
                }
            }
        }
    }
}
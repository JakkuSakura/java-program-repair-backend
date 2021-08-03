package org.bytecamp.program_repair.backend.utils;

import java.io.File;
import java.io.IOException;

public class FileWriter implements IWriter {
    final private java.io.Writer file;
    public FileWriter(File file) throws IOException {
        this.file = new java.io.FileWriter(file);
    }
    @Override
    public void write(String chunk) {
        try {
            file.write(chunk);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

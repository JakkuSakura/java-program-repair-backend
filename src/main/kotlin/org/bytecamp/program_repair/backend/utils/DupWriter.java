package org.bytecamp.program_repair.backend.utils;

import java.util.ArrayList;

public class DupWriter implements IWriter {
    ArrayList<IWriter> writers = new ArrayList<>();

    public void add(IWriter writer) {
        writers.add(writer);
    }

    @Override
    public void write(String chunk) {
         for (IWriter writer : writers) {
            writer.write(chunk);
        }
    }
    @Override
    public void writeln(String chunk) {
        for (IWriter writer : writers) {
            writer.writeln(chunk);
        }
    }
}

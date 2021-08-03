package org.bytecamp.program_repair.backend.utils;

public interface IWriter {
    void write(String chunk);
    default void writeln(String line) {
        this.write(line + "\n");
    }
}

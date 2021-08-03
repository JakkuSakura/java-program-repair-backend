package org.bytecamp.program_repair.backend.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class WriterStream extends OutputStream {
    private final IWriter writer;
    private final StringBuffer buffer = new StringBuffer();

    public WriterStream(IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(int b) throws IOException {
        if (b == '\n') {
            if (buffer.length() > 0) {
                writer.writeln(buffer.toString());
                buffer.setLength(0);
            }
            return;
        }
        if (buffer.length() > 300) {
            writer.write(buffer.toString());
            buffer.setLength(0);
        }
        buffer.append(b);
    }

    @Override
    public void write(byte b[]) throws IOException {
        if (buffer.length() > 0) {
            writer.write(buffer.toString());
            buffer.setLength(0);
        }
        writer.write(new String(b, StandardCharsets.UTF_8));
    }

    public void write(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        if (buffer.length() > 0) {
            writer.write(buffer.toString());
            buffer.setLength(0);
        }
        writer.write(new String(Arrays.copyOfRange(b, off, off + len), StandardCharsets.UTF_8));
    }

    @Override
    public void flush() throws IOException {
        if (buffer.length() > 0) {
            writer.write(buffer.toString());
            buffer.setLength(0);
        }
    }

    @Override
    public void close() throws IOException {
        if (buffer.length() > 0) {
            writer.write(buffer.toString());
            buffer.setLength(0);
        }
    }
}

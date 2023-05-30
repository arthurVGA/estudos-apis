package br.com.artius.html.io;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriter {
    private final String fileName;

    public HTMLWriter(final String fileName) {
        this.fileName = "src/main/resources/resultado/" + fileName;
    }

    public void writeHTML(final String html) {
        try (final FileWriter writer = new FileWriter(this.fileName)){
            writer.write(html);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

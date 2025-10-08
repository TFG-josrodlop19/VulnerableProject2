package com.example;

import org.dom4j.io.SAXReader;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VulnerableApp {

    /**
     * Fuzzable method that processes XML content.
     */
    public static void processXml(String xmlContent) throws Exception {
        // Direct usage of SAXReader without secure configuration
        SAXReader reader = new SAXReader();

        // In this version, the reader is not configured to be secure by default.
        // When parsing, it will process external entities.
        reader.read(new ByteArrayInputStream(xmlContent.getBytes()));
    }

    /**
     * Main method for manual testing.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java -jar <jar_file> <file.xml>");
            return;
        }
        String fileName = args[0];
        System.out.println("[+] Processing XML from: " + fileName);
        String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        processXml(fileContent);
    }
}
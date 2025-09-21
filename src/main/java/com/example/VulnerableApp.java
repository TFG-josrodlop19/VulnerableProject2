package com.example;

import org.dom4j.io.SAXReader;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VulnerableApp {

    /**
     * Método "fuzzable" que contiene la lógica vulnerable.
     */
    public static void processXml(String xmlContent) throws Exception {
        // Se usa directamente la clase de la dependencia dom4j
        SAXReader reader = new SAXReader();
        
        // En esta versión, el reader no está configurado para ser seguro por defecto.
        // Al parsear, procesará las entidades externas.
        reader.read(new ByteArrayInputStream(xmlContent.getBytes()));
    }

    /**
     * Método main para pruebas manuales.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Uso: java -jar <jar_file> <fichero.xml>");
            return;
        }
        String fileName = args[0];
        System.out.println("[+] Procesando XML desde: " + fileName);
        String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        processXml(fileContent);
    }
}
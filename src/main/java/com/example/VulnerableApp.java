package com.example;

import com.thoughtworks.xstream.XStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VulnerableApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar <jar_file> <fichero.xml>");
            return;
        }

        String fileName = args[0];
        System.out.println("[+] Leyendo XML desde el fichero: " + fileName);

        try {
            // Leemos todo el contenido del fichero a un String
            String xmlContent = new String(Files.readAllBytes(Paths.get(fileName)));

            XStream xstream = new XStream();
            
            // --- ¡LA LLAMADA VULNERABLE A LA DEPENDENCIA! ---
            // Este método parece inofensivo. El desarrollador solo quiere parsear un XML.
            // Sin embargo, internamente, esta versión de XStream realiza una deserialización
            // insegura que puede ser explotada si el XML está manipulado.
            Object data = xstream.fromXML(xmlContent);

            System.out.println("[+] ¡XML procesado con éxito!");
            System.out.println("   - Objeto deserializado de la clase: " + data.getClass().getName());

        } catch (Exception e) {
            System.err.println("[!] Ocurrió un error al procesar el XML.");
            e.printStackTrace();
        }
    }
}
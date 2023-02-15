package org.example.Services;

import org.example.RESTService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Servicio que retorna un archivo HTML
 */
public class HTMLService implements RESTService {
    private String type = "text/html";

    /**
     * Header del archivo HTML
     * @return String con el header del archivo
     */
    @Override
    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: " + type +"\r\n" +
                "\r\n";
    }


    /**
     * Respuesta del archivo HTML
     * @return String con el cuerpo del archivo
     */
    @Override
    public String getResponse() throws IOException {
        Path file = Paths.get("src/main/resources/prueba.html");
        byte[] fileArray = Files.readAllBytes(file);

        return new String(fileArray);
    }

    @Override
    public void type(String type) {
        this.type = type;
    }
}

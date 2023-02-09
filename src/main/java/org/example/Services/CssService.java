package org.example.Services;

import org.example.RESTService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Servicio que retorna un archivo CSS
 */
public class CssService implements RESTService {

    /**
     * Header del archivo Css
     * @return String con el header del archivo
     */
    @Override
    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/css\r\n" +
                "\r\n";
    }

    /**
     * Respuesta del archivo Css
     * @return String con el cuerpo del archivo
     */
    @Override
    public String getResponse() throws IOException {
        Path file = Paths.get("src/main/resources/prueba.css");
        byte[] fileArray = Files.readAllBytes(file);

        return new String(fileArray);
    }
}

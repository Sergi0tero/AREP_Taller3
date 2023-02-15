package org.example.Services;

import org.example.RESTService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Servicio que retorna un archivo de imagen
 */
public class IMGService implements RESTService {
    private String type = "image/jpg";

    /**
     * Header del archivo de imagen, en este caso jpg
     * @return String con el header del archivo
     */
    @Override
    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: " + type +"\r\n" +
                "\r\n";
    }

    /**
     * Respuesta del archivo de imagen, en este caso jpg
     * @return String con el cuerpo del archivo
     */
    @Override
    public String getResponse() throws IOException {
        Path file = Paths.get("src/main/resources/prueba.jpg");
        byte[] fileArray = Files.readAllBytes(file);

        return new String(fileArray);
    }

    @Override
    public void type(String type) {
        this.type = type;
    }
}

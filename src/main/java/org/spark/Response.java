package org.spark;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {
    private String type = "application/json";

        /**
         * Header del archivo HTML
         * @return String con el header del archivo
         */
        public String getHeader() {
            return "HTTP/1.1 200 OK\r\n" +
                    "Content-type: " + type +"\r\n" +
                    "\r\n";
        }


        /**
         * Respuesta del archivo HTML
         * @return String con el cuerpo del archivo
         */
        public String getResponse() throws IOException {
            Path file = Paths.get("src/main/resources/prueba.html");
            byte[] fileArray = Files.readAllBytes(file);

            return new String(fileArray);
        }

        public void type(String type) {
            this.type = type;
        }
}

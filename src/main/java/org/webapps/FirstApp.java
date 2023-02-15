package org.webapps;

import org.example.HttpServer;
import org.example.Services.*;

import java.io.IOException;

/**
 * Main que inicia y obtiene la instancia del servidor HTTP y añade los nuevos servicios
 */
public class FirstApp {

    /**
     * añade los servicios al servidor
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.run(args);
    }
}

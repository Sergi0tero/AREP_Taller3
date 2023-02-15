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
        server.addService("/prueba.html", new HTMLService());
        server.addService("/prueba.js", new JsService());
        server.addService("/prueba.img", new IMGService());
        server.addService("/prueba.css", new CssService());
        server.addService("/error404.html", new Error404());
        server.run(args);
    }
}

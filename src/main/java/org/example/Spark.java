package org.example;


import org.example.Services.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Spark {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        RequestMethod getMethod = (getFile) -> {
            try {
                return server.get(getFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        server.addMethods("GET", getMethod);

        server.addService("/prueba.html", new HTMLService());
        server.addService("/prueba.js", new JsService());
        server.addService("/prueba.img", new IMGService());
        server.addService("/prueba.css", new CssService());
        server.addService("/error404.html", new Error404());
        server.run(args);
//        server.createContext("/api/greeting", (exchange -> {
//
//            if ("GET".equals(exchange.getRequestMethod())) {
//                String responseText = "Hello World! from our framework-less REST API\n";
//                exchange.sendResponseHeaders(200, responseText.getBytes().length);
//                OutputStream output = exchange.getResponseBody();
//                output.write(responseText.getBytes());
//                output.flush();
//            } else {
//                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
//            }
//            exchange.close();
//        }));
//
//
//        server.setExecutor(null); // creates a default executor
//        server.start();

    }
}

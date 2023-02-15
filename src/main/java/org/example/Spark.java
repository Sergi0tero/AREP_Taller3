package org.example;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Spark {
    interface RequestedMethod{
        String runMethod(String getFile);
    }
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.run(args);
        System.out.println("fsdafasdf");
        RequestedMethod getMethod = (getFile) -> {
            try {
                return server.get(getFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        System.out.println("prueba" + getMethod.runMethod("/apps/prueba.html"));
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

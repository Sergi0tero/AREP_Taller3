package org.example;

import org.example.Services.*;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Servidor HTTP encargado de tomar y procesar las peticiones
 */
public class HttpServer {

    private static HttpServer _instance = new HttpServer();
    private Map<String, RequestMethod> methods = new HashMap<>();
    private Map<String, RESTService> services = new HashMap<>();

    private HttpServer (){}

    /**
     * Retorna la instancia del HTTPServer
     * @return instancia del HTTPServer
     */
    public static HttpServer getInstance() {
        return _instance;
    }

    /**
     * Conexion con el puerto e inicialización del html inicial
     * @param args
     * @throws IOException
     */
    public void run(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean first_line = true;
            String request = "/simple";
            String requestedMethod = "";
            while ((inputLine = in.readLine()) != null) {

                if (first_line) {
                    requestedMethod = inputLine.split(" ")[0];
                    request = inputLine.split(" ")[1];
                    first_line = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            if (request.startsWith("/apps/")) {
                outputLine = methods.get(requestedMethod).runMethod(request.substring(5));
            }
            else if (request.equals("/")){
                outputLine = htmlGetForm();
            } else {
                outputLine = methods.get(requestedMethod).runMethod(request.substring(5));
                outputLine = get("/error404.html");
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    public String get(String serviceName) throws IOException {
        return executeService(serviceName);
    }

    /**
     * Creacion del HTML inicial que ve el usuario al cargar la pagina
     * @return HTML inicial
     */
    private String htmlGetForm(){
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Form Example</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>New API REST</h1>\n" +
                "        <h2>Available links:</h2>\n" +
                "        <ul> <li> /apps/html </li>  <li> /apps/js </li>  <li> /apps/img </li>  <li> /apps/css </li> </ul>\n" +
                "    </body>\n" +
                "</html>";

    }

    /**
     * Buca y retorna el servicio solicitado por la URL, de no encontrarse salta la pantalla de error
     * @param serviceName nombre del servicio
     * @return Archivo solicitado
     * @throws IOException
     */
    private String executeService(String serviceName) throws IOException {
        try{
            RESTService rs = services.get(serviceName);
            String header = rs.getHeader();
            String body = rs.getResponse();
            return header + body;
        } catch (Exception e){
            RESTService rs = services.get("/error404.html");
            String header = rs.getHeader();
            String body = rs.getResponse();
            return header + body;
        }
    }

    /**
     * Añade los servicios al arreglo
     * @param key nombre del nuevo servicio
     * @param service Servicio creado
     */
    public void addService(String key, RESTService service) {
        services.put(key, service);
    }

    public void addMethods(String key, RequestMethod method) {
        methods.put(key, method);
    }
}

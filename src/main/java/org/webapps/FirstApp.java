package org.webapps;

import org.example.HttpServer;
import org.example.RESTService;
import org.example.Services.*;
import org.spark.RequestMethod;
import org.spark.Response;
import org.spark.Spark;

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
        Spark spark = new Spark();
        HttpServer server = HttpServer.getInstance();
        RequestMethod get = (req, res) -> {
            try{
                res.type("text/html");
                String header = res.getHeader();
                String body = res.getResponse();
                return header + body;
            } catch (Exception e){
                Response rs = new Response("/error404.html");
                String header = rs.getHeader();
                String body = rs.getResponse();
                return header + body;
            }
        };
        RequestMethod post = (req, res) -> {

        };
        server.createContext("GET", get);
        server.run(args);
    }
}

package org.spark;


import org.example.RESTService;

import java.io.IOException;

public class Spark {
    public String get(String path, RequestMethod requestMethod) throws IOException {
        return requestMethod.runMethod(new Request(), new Response(path));
    }
}

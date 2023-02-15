package org.spark;


import org.example.RESTService;

import java.io.IOException;

public class Spark {
    public String get(RESTService service, RequestMethod requestMethod) throws IOException {
        return requestMethod.runMethod(new Request(), service);
    }
}

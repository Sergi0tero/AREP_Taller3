package org.spark;

import org.example.RESTService;

import java.io.IOException;

public interface RequestMethod{
    String runMethod(Request req, Response res) throws IOException;
}
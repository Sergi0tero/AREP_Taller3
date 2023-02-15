package org.example;

import java.io.IOException;

/**
 * Interfaz que implementan los servicios creados
 */
public interface RESTService {

    /**
     * Encabezado de los archivos seleccionados
     * @return Encabezado del archivo
     */
    public String getHeader();

    /**
     * Cuerpo de los archivos seleccionados
     * @return Cuerpo del archivo
     * @throws IOException
     */
    public String getResponse() throws IOException;

    public void type(String type);
}

## Autor:
### Sergio Andrés Otero Herrera

# Taller 3 AREP:
En este taller se hace la creacion de una API sin uso de librerias, extendiendo el uso ahora a una simulacion de Spark.

## Funcionamiento:
La aplicacion se inicia con el URL de localhost:35000, para navegar entre los distintos archivos se debe agregar los urls mostrados en la pantalla inicial.

## Prerrequisitos
- GIT
- JAVA
- MVN

## Instalación
De querer usar este codigo, se tiene que hacer lo siguiente:

Se clona el repositorio

```
git clone https://github.com/Sergi0tero/AREP_Taller3.git
```

Ahora, si queremos verificar la integridad del codigo

```
mvn package
```
## Correr el código:
Para correr la clase main, la cual se encuentra en FirstApp.java, corremos el siguiente comando en la terminal:

```
mvn exec:java
```

## Diseño
El proyecto fue realizado en Java. El ciclo de vida empieza por el usuario, quien, usando las opciones dadas en el inicio, elige el archivo que desee. Continua con el servidor redirecciona dependiendo del servicio elegido.
Este servicio lee el archivo seleccionado en una direccion especificada. Retornando asi el archivo y mostrandolo en pantalla.

## Patrones
- Singleton

## Modular
Estas son las diferentes capaz que podemos ver:
- Servicios
- Spark
- Servidor

## Pruebas
No se realizaron pruebas para este codigo. Pero se puede verifcar el funcionamiento comparando los archivos dentro del directorio "resources" con lo que retorna la API

## Version
1.0


package org.ieszaidinvergeles.dam.capitulo1;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



public class OperacionesCarpetas {


    /**
     * Crea una estructura de carpetas para un proyecto
     *
     * @param ruta carpeta raíz del proyecto
     */
    public static void crearDirectoriosProyecto(String ruta) {
        Path data = Paths.get(ruta, "private", "data");
        Path invoces = Paths.get(ruta, "private", "invoces");
        Path web = Paths.get(ruta, "public", "html", "web");
        Path images = Paths.get(ruta, "public", "html", "images");
        Path pages = Paths.get(ruta, "public", "html", "pages");
        Path textos = Paths.get(ruta, "public", "textos");
        
        try{
            Files.createDirectories(data);
            Files.createDirectories(invoces);
            Files.createDirectories(web);
            Files.createDirectories(images);
            Files.createDirectories(pages);
            Files.createDirectories(textos);
        }catch(IOException e){
            System.err.println("Error al crear los directorios: "+e.getMessage());
        }

    }

    /**
     * Cambia el nombre del directorio de origen por el de destino. 
     * Se debe comprobar si existen y permiten realizar esta operación. Imagina,
     * por ejemplo, el caso de que destino ya sea una carpeta. En este caso, 
     * se informa y no se hace nada. 
     * @param origen nombre del directorio a cambiar
     * @param destino nuevo nombre del directorio
     */
    public static void moverDirectorio(String origen, String destino) {
        Path directorioOrigen = Paths.get(origen);
        Path directorioDestino = Paths.get(destino);
        
        try {
            Files.move(directorioOrigen, directorioOrigen);
        } catch (FileAlreadyExistsException ex) {
            System.err.println(destino +" ya existe");
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }

    /**
     * Borra una directorio recursivamente, aunque tenga ficheros o carpetas
     *
     * @param ruta de la carpeta a borrar
     */
    public static void borrarDirectorio(String ruta) {
        Path rootPath = Paths.get(ruta);

        try {
          Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
              System.out.println("delete file: " + file.toString());
              Files.delete(file);
              return FileVisitResult.CONTINUE;
            }
        
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
              Files.delete(dir);
              System.out.println("delete dir: " + dir.toString());
              return FileVisitResult.CONTINUE;
            }
          });
        } catch(IOException e){
          System.err.println("Error: "+e.getMessage());
        }

    }

}

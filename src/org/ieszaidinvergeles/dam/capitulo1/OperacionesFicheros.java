
package org.ieszaidinvergeles.dam.capitulo1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OperacionesFicheros {

    /**
     * Crea 10 ficheros en cada carpeta del proyecto. Utiliza para generar los
     * nombres aleatorios el método Utils.generateRandomFileName(7) dónde 7 es
     * la longitud del fichero
     *
     * @param ruta
     */
    public static void crearFicherosProyecto(String ruta) {
        for (int i = 0; i < 10; i++) {
            try {
                Path data = Paths.get(ruta, "private", "data", Utils.generateRandomFileName(7));
                Path invoces = Paths.get(ruta, "private", "invoces", Utils.generateRandomFileName(7));
                Path textos = Paths.get(ruta, "public", "textos", Utils.generateRandomFileName(7));
                Path images = Paths.get(ruta, "public", "html", "images", Utils.generateRandomFileName(7));
                Path pages = Paths.get(ruta, "public", "html", "pages", Utils.generateRandomFileName(7));
                Path web = Paths.get(ruta, "public", "html", "web", Utils.generateRandomFileName(7));
                
                
                Files.createFile(data);
                Files.createFile(invoces);
                Files.createFile(textos);
                Files.createFile(images);
                Files.createFile(pages);
                Files.createFile(web);
            } catch (IOException ex) {
                System.err.println("Error: "+ex.getMessage());
            }
        }
    }

    /**
     * Mueve los ficheros de la carpeta origen, que cumplan el/los criterio/s, 
     * a la carpeta destino
     * @param origen carpeta de origen 
     * @param destino carpeta de destino
     * @param criterio condiciones a cumplir por los ficheros 
     */
    public static void moverArchivos(String origen, String destino, Predicate<Path> criterio) {
        
    }
    
    /**
     * Busca carpetas y ficheros en ruta, de forma recursiva, que cumplan con 
     * las condiciones de criterio
     * @param ruta directorio raíz desde comienza la búsqueda recursiva
     * @param criterio condiciones que deben cumplir los directorios o ficheros
     * @return Lista de rutas 
     */
    public static List<Path> buscar(String ruta, Predicate<Path> criterio){
        return null; //Cambiar esta línea de código
    }
}

package controladores;

import entidades.Cantidad;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Usuario;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author venganzaalchocolate
 */
public class Backup {
       public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }
       
       public static void crearDirectorios(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectories(directory);
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }
       
        public static Stream<Path> listarTodo(String ruta) {

        try {   
            Stream<Path> miStream = Files.walk(Paths.get(ruta));
            return miStream;        
        } catch (IOException e) {
            System.out.println("Error listando directorios");
        }
        return null;
    }
          // Escribe un String a un fichero, sobreescribiendo si existe
    public static void escribirString(String datos, String nombreFichero) {

        try {
            Files.write(Paths.get(nombreFichero), datos.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }

    // Método para escribir una lista de String, sobreescribiendo si el fichero existe
    public static void escribirListaString(List<String> lista, String nombreFichero) {
        
        try {
            Files.write(Paths.get(nombreFichero), lista, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
            System.out.println(ex);
        }
    }
    
    public static List<String> tranformarListaReceta(List<Receta> lista){
        List<String> tmp=new ArrayList<>();
        for (Receta receta : lista) {
            tmp.add(receta.toString());
        }
    return tmp;
    }
    
    public static List<String> tranformarListaIngrediente(List<Ingrediente> lista){
        List<String> tmp=new ArrayList<>();
        for (Ingrediente receta : lista) {
            tmp.add(receta.toString());
        }
    return tmp;
    }
    
    public static List<String> tranformarListaUsuario(List<Usuario> lista){
        List<String> tmp=new ArrayList<>();
        for (Usuario receta : lista) {
            tmp.add(receta.toString());
        }
    return tmp;
    }
    
    public static List<String> tranformarCantidad(List<Cantidad> lista){
        List<String> tmp=new ArrayList<>();
        for (Cantidad receta : lista) {
            tmp.add(receta.toString());
        }
    return tmp;
    }
    
    
}

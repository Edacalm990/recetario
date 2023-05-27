package controladores;

import entidades.Cantidad;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author venganzaalchocolate
 */
public class Backup {
       public static boolean crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
            return true;
        } catch (FileAlreadyExistsException faee) {
            if(JOptionPane.showConfirmDialog(null, "Ya hay una copia de seguridad con la fecha de hoy, quieres sobreescribirla?")==0){
                 Path p1 = Paths.get(ruta);
                 try {
                    deleteDirectory(p1);
                    crearDirectorio(ruta);
                    return true;
                } catch (Exception e) {
                     System.out.println("No se ha podido elimionar los archivos");

                }
            } else {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
            }
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }
        return false;
    }
       
       public static void deleteDirectory(Path directory) throws IOException {
        Files.walk(directory)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
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
    
        public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
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
        for (Ingrediente ingrediente : lista) {
            
            tmp.add(ingrediente.toString());
            System.out.println(ingrediente.toString());
        }
    return tmp;
    }
    
    public static List<String> tranformarListaUsuario(List<Usuario> lista){
        List<String> tmp=new ArrayList<>();
        for (Usuario usuario : lista) {
            tmp.add(usuario.toString());
        }
    return tmp;
    }
    
    public static List<String> tranformarCantidad(List<Cantidad> lista){
        List<String> tmp=new ArrayList<>();
        for (Cantidad cantidad : lista) {
            System.out.println(cantidad.toString());
            tmp.add(cantidad.toString());
        }
    return tmp;
    }
    
    
    public static List<String[]> LeerFicherosTexto(String ruta) {
        List<String[]> listaString=new ArrayList<>();
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + ruta);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(ruta), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                listaString.add(tokens);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaString;
}
    
    
    
    
}

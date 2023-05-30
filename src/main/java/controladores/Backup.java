package controladores;

import static controladores.Miscelanea.controladorCantidad;
import static controladores.Miscelanea.controladorIngrediente;
import static controladores.Miscelanea.controladorReceta;
import static controladores.Miscelanea.controladorUsuario;
import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import vistas.Portada;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author venganzaalchocolate
 */
// clase con métodos estaticos para crear y restaurar el backup
public class Backup {

    // método que crea directorio para el backup, si ya existe la sobreescribe
    public static boolean crearDirectorio(String ruta) {
        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
            return true;
        } catch (FileAlreadyExistsException faee) {
            if (JOptionPane.showConfirmDialog(null, "Ya hay una copia de seguridad con la fecha de hoy, quieres sobreescribirla?") == 0) {
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

    // método que elimina un directorio y todo su contenido
    public static void deleteDirectory(Path directory) throws IOException {
        Files.walk(directory)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    // método que crea varios directorios
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

    // método que muestra el contenido de un directorio
    public static Stream<Path> listarTodo(String ruta) {

        try {
            Stream<Path> miStream = Files.walk(Paths.get(ruta));
            return miStream;
        } catch (IOException e) {
            System.out.println("Error listando directorios");
        }
        return null;
    }
    
    //crea un fichero
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

    // método para borrar un fichero
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

    // los métodos a continuación convierten listas de objetos en listas de string
    public static List<String> tranformarListaReceta(List<Receta> lista) {
        List<String> tmp = new ArrayList<>();
        for (Receta receta : lista) {
            tmp.add(receta.toString());
        }
        return tmp;
    }

    public static List<String> tranformarListaIngrediente(List<Ingrediente> lista) {

        List<String> tmp = new ArrayList<>();
        for (Ingrediente ingrediente : lista) {
            tmp.add(ingrediente.toString());
        }
        return tmp;
    }

    public static List<String> tranformarListaUsuario(List<Usuario> lista) {
        List<String> tmp = new ArrayList<>();
        for (Usuario usuario : lista) {
            tmp.add(usuario.toString());
        }
        return tmp;
    }

    public static List<String> tranformarCantidad(List<Cantidad> lista) {
        List<String> tmp = new ArrayList<>();
        for (Cantidad cantidad : lista) {
            tmp.add(cantidad.toString());
        }
        return tmp;
    }

    // lee un fichero y te devuelve una lista de String []
    public static List<String[]> LeerFicherosTexto(String ruta) {
        List<String[]> listaString = new ArrayList<>();
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + ruta);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(ruta), "UTF-8")) {
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

    // los métodos a continuación convierten una lista de strign en una lista de objetos
    public static Ingrediente convertirListingrediente(String[] listaString) {
        Ingrediente tmp = new Ingrediente();
        tmp.setCodIngrediente(Integer.valueOf(listaString[0]));
        tmp.setNombreIngrediente(listaString[1]);

        return tmp;
    }

    public static Usuario convertirListusuario(String[] listaString) {
        Usuario tmp = new Usuario();
        tmp.setCodUsuario(Integer.valueOf(listaString[0]));
        tmp.setNombre(listaString[1]);
        tmp.setEmail(listaString[2]);
        return tmp;
    }

    public static Receta convertirListreceta(String[] listaString) {
        Receta tmp = new Receta();
        //tmp.setCodUsuario(Integer.valueOf(listaString[0]));
        tmp.setCodReceta(Integer.valueOf(listaString[0]));
        tmp.setNombreReceta(listaString[1]);
        tmp.setElaboracion(listaString[2]);
        Usuario usuario = controladorUsuario.findByNombre(listaString[3]);
        tmp.setCreador(usuario);
        return tmp;
    }

    public static Cantidad convertirListcantidad(String[] listaString) {

        Ingrediente ingrediente = controladorIngrediente.findByNombreIngrediente(listaString[0]);
        Receta receta = controladorReceta.findByNombreReceta(listaString[1]);
        Cantidad tmp = new Cantidad(ingrediente, receta, Integer.parseInt(listaString[2]));
        return tmp;
    }

    // este método borra la BBDD, lo útilizo cuando restauro un backup
    // se debe borrar en orden sino salta una excepción al entrar relaciones entre las tablas
    public static void borrarBBDD() {
        controladorCantidad.findCantidadEntities().forEach((t) -> {
            try {
                controladorCantidad.destroy(t.getCantidadPK());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Miscelanea.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        controladorIngrediente.findIngredienteEntities().forEach((t) -> {
            try {
                controladorIngrediente.destroy(t.getCodIngrediente());
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(Miscelanea.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Miscelanea.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        controladorReceta.findRecetaEntities().forEach((t) -> {
            try {
                controladorReceta.destroy(t.getCodReceta());
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(Miscelanea.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Miscelanea.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        controladorUsuario.findUsuarioEntities().forEach((t) -> {
            try {
                controladorUsuario.destroy(t.getCodUsuario());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Portada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );

    }

    // método para crear el backup
    public static void crearBackup() {
        String fecha = LocalDate.now().toString();
        boolean existeDirectorio = Backup.listarTodo("." + File.separator).anyMatch((t) -> t.startsWith("." + File.separator + "backup"));
        /*
        La clase java.io.File contiene cuatro variables de separador estático.
        separator: Un String del separador dependiendo de la plataforma. Para Windows, es \ y para Unix es /
        separatorChar: Igual que separator pero nos da un Char
        pathSeparator: Variable dependiente de la plataforma para separadores de ruta. Por ejemplo PATH o CLASSPATH Para Unix es : y para Windows es ; .
        pathSeparatorChar: Igual que pathSeparator pero del tipo char
         */
        // ();
        do {
              // comprueba si el directorio backup existe
              // uso File.separator para que funcione tanto en ubuntu como en windows
            existeDirectorio = Backup.listarTodo("." + File.separator).anyMatch((t) -> t.startsWith("." + File.separator + "backup"));
            if (existeDirectorio) {
                boolean creado = Backup.crearDirectorio(".%sbackup%s%s".formatted(File.separator, File.separator, fecha)); 
                List<Ingrediente> listaIngredientes = controladorIngrediente.findIngredienteEntities();
                List<Receta> listaRecetas = controladorReceta.findRecetaEntities();
                List<Usuario> listaUsuarios = controladorUsuario.findUsuarioEntities();
                List<Cantidad> listaCantidades = controladorCantidad.findCantidadEntities();
                if (creado) {
                    String[] nombres = {"cantidad", "ingrediente", "receta", "usuario"};
                    List[] listas = {
                        // llamo a los métodos para transformar las listas
                        Backup.tranformarCantidad(listaCantidades),
                        Backup.tranformarListaIngrediente(listaIngredientes),
                        Backup.tranformarListaReceta(listaRecetas),
                        Backup.tranformarListaUsuario(listaUsuarios)};
                    for (int i = 0; i < listas.length; i++) {
                        // creo los archivos
                        Backup.escribirListaString(listas[i], ".%sbackup%s%s%s%s%s".formatted(File.separator, File.separator, fecha, File.separator, nombres[i], ".csv"));
                    }
                    JOptionPane.showMessageDialog(null, "Backup creado con éxito");
                }
            } else {
                // sino existe lo creo
                Backup.crearDirectorio("." + File.separator + "backup");
            }

        } while (!existeDirectorio);

    }
}

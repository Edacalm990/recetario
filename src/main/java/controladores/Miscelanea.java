/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Cantidad;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vistas.Portada;

/**
 *
 * @author eli
 */
public class Miscelanea {

    public static RecetaJpaController controladorReceta = new RecetaJpaController(Miscelanea.getEntityManager());
    public static UsuarioJpaController controladorUsuario = new UsuarioJpaController(Miscelanea.getEntityManager());
    public static CantidadJpaController controladorCantidad = new CantidadJpaController(Miscelanea.getEntityManager());
    public static IngredienteJpaController controladorIngrediente = new IngredienteJpaController(Miscelanea.getEntityManager());

    public static EntityManagerFactory getEntityManager() {
        // EntityManager permite realizar operaciones con la BD
        // Se obtiene a través del EntityManagerFactory y este a su vez se genera
        // a partir del nombre de la unidad de persistencia (fichero persistence.xml)
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recetario_Recetario_jar_1.0-SNAPSHOTPU");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recetario_Windows");
        EntityManager em = entityManagerFactory.createEntityManager();
        return entityManagerFactory;
    }

    
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
        tmp.setApellido1(listaString[2]);
        tmp.setApellido2(listaString[3]);
        tmp.setEmail(listaString[4]);
        return tmp;
    }
    
        public static Receta convertirListreceta(String[] listaString) {
        Receta tmp = new Receta();
        //tmp.setCodUsuario(Integer.valueOf(listaString[0]));
        tmp.setCodReceta(Integer.valueOf(listaString[0]));
        tmp.setNombreReceta(listaString[1]);
        tmp.setElaboracion(listaString[2]);
        Usuario usuario=(controladorUsuario.findByEmail(listaString[4])); 
        tmp.setCreador(usuario);
        return tmp;
    }

    public static Cantidad convertirListcantidad(String[] listaString) {

        Ingrediente ingrediente=controladorIngrediente.findByNombreIngrediente(listaString[0]);
        Receta receta=controladorReceta.findByNombreReceta(listaString[1]);
        Cantidad tmp = new Cantidad(ingrediente, receta, Integer.parseInt(listaString[2]));
        return tmp;
    }

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
        });
        
       
        
       
    }

}

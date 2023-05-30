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
        //-----------------------------------------------
        // esta frase comentada la descomento cuando estoy en ubuntu y comento la de abajo y viceversa cuando estoy en windows
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recetario_Recetario_jar_1.0-SNAPSHOTPU");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recetario_Windows");
        //-----------------------------------------------
        EntityManager em = entityManagerFactory.createEntityManager();
        return entityManagerFactory;
    }

    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eli
 */
public class Miscelanea {
        public static EntityManagerFactory getEntityManager() {
        // EntityManager permite realizar operaciones con la BD
        // Se obtiene a través del EntityManagerFactory y este a su vez se genera
        // a partir del nombre de la unidad de persistencia (fichero persistence.xml)
       //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recetario_Recetario_jar_1.0-SNAPSHOTPU");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recetario_Windows");
        EntityManager em = entityManagerFactory.createEntityManager();
        return entityManagerFactory;
    }
    
}

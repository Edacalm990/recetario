/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Cantidad;
import entidades.Ingrediente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author eli
 */
public class IngredienteJpaController implements Serializable {

    public IngredienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ingrediente ingrediente) {
        if (ingrediente.getCantidadList() == null) {
            ingrediente.setCantidadList(new ArrayList<Cantidad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cantidad> attachedCantidadList = new ArrayList<Cantidad>();
            for (Cantidad cantidadListCantidadToAttach : ingrediente.getCantidadList()) {
                cantidadListCantidadToAttach = em.getReference(cantidadListCantidadToAttach.getClass(), cantidadListCantidadToAttach.getCantidadPK());
                attachedCantidadList.add(cantidadListCantidadToAttach);
            }
            ingrediente.setCantidadList(attachedCantidadList);
            em.persist(ingrediente);
            for (Cantidad cantidadListCantidad : ingrediente.getCantidadList()) {
                Ingrediente oldIngredienteOfCantidadListCantidad = cantidadListCantidad.getIngrediente();
                cantidadListCantidad.setIngrediente(ingrediente);
                cantidadListCantidad = em.merge(cantidadListCantidad);
                if (oldIngredienteOfCantidadListCantidad != null) {
                    oldIngredienteOfCantidadListCantidad.getCantidadList().remove(cantidadListCantidad);
                    oldIngredienteOfCantidadListCantidad = em.merge(oldIngredienteOfCantidadListCantidad);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ingrediente ingrediente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ingrediente persistentIngrediente = em.find(Ingrediente.class, ingrediente.getCodIngrediente());
            List<Cantidad> cantidadListOld = persistentIngrediente.getCantidadList();
            List<Cantidad> cantidadListNew = ingrediente.getCantidadList();
            List<String> illegalOrphanMessages = null;
            for (Cantidad cantidadListOldCantidad : cantidadListOld) {
                if (!cantidadListNew.contains(cantidadListOldCantidad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cantidad " + cantidadListOldCantidad + " since its ingrediente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Cantidad> attachedCantidadListNew = new ArrayList<Cantidad>();
            for (Cantidad cantidadListNewCantidadToAttach : cantidadListNew) {
                cantidadListNewCantidadToAttach = em.getReference(cantidadListNewCantidadToAttach.getClass(), cantidadListNewCantidadToAttach.getCantidadPK());
                attachedCantidadListNew.add(cantidadListNewCantidadToAttach);
            }
            cantidadListNew = attachedCantidadListNew;
            ingrediente.setCantidadList(cantidadListNew);
            ingrediente = em.merge(ingrediente);
            for (Cantidad cantidadListNewCantidad : cantidadListNew) {
                if (!cantidadListOld.contains(cantidadListNewCantidad)) {
                    Ingrediente oldIngredienteOfCantidadListNewCantidad = cantidadListNewCantidad.getIngrediente();
                    cantidadListNewCantidad.setIngrediente(ingrediente);
                    cantidadListNewCantidad = em.merge(cantidadListNewCantidad);
                    if (oldIngredienteOfCantidadListNewCantidad != null && !oldIngredienteOfCantidadListNewCantidad.equals(ingrediente)) {
                        oldIngredienteOfCantidadListNewCantidad.getCantidadList().remove(cantidadListNewCantidad);
                        oldIngredienteOfCantidadListNewCantidad = em.merge(oldIngredienteOfCantidadListNewCantidad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ingrediente.getCodIngrediente();
                if (findIngrediente(id) == null) {
                    throw new NonexistentEntityException("The ingrediente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ingrediente ingrediente;
            try {
                ingrediente = em.getReference(Ingrediente.class, id);
                ingrediente.getCodIngrediente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ingrediente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cantidad> cantidadListOrphanCheck = ingrediente.getCantidadList();
            for (Cantidad cantidadListOrphanCheckCantidad : cantidadListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ingrediente (" + ingrediente + ") cannot be destroyed since the Cantidad " + cantidadListOrphanCheckCantidad + " in its cantidadList field has a non-nullable ingrediente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ingrediente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ingrediente> findIngredienteEntities() {
        return findIngredienteEntities(true, -1, -1);
    }

    public List<Ingrediente> findIngredienteEntities(int maxResults, int firstResult) {
        return findIngredienteEntities(false, maxResults, firstResult);
    }

    private List<Ingrediente> findIngredienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ingrediente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ingrediente findIngrediente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ingrediente.class, id);
        } finally {
            em.close();
        }
    }

    public int getIngredienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ingrediente> rt = cq.from(Ingrediente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
         // Método añadido, usando una named query de la entidad ingrediente
    public Ingrediente findByNombreIngrediente(String nombre){
        EntityManager em = getEntityManager();
        // Se crea la query usando el nombre de la named query
        Query q = em.createNamedQuery("Ingrediente.findByNombreIngrediente");
        // Se establece el parámetro de la consulta
        q.setParameter("nombreIngrediente", nombre);

        
        return (Ingrediente)q.getSingleResult();
    }
    
            
     
    
    
}

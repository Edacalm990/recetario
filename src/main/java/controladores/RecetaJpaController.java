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
import entidades.Receta;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author venganzaalchocolate
 */
public class RecetaJpaController implements Serializable {

    public RecetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Receta receta) {
        if (receta.getCantidadList() == null) {
            receta.setCantidadList(new ArrayList<Cantidad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cantidad> attachedCantidadList = new ArrayList<Cantidad>();
            for (Cantidad cantidadListCantidadToAttach : receta.getCantidadList()) {
                cantidadListCantidadToAttach = em.getReference(cantidadListCantidadToAttach.getClass(), cantidadListCantidadToAttach.getCantidadPK());
                attachedCantidadList.add(cantidadListCantidadToAttach);
            }
            receta.setCantidadList(attachedCantidadList);
            em.persist(receta);
            for (Cantidad cantidadListCantidad : receta.getCantidadList()) {
                Receta oldRecetaOfCantidadListCantidad = cantidadListCantidad.getReceta();
                cantidadListCantidad.setReceta(receta);
                cantidadListCantidad = em.merge(cantidadListCantidad);
                if (oldRecetaOfCantidadListCantidad != null) {
                    oldRecetaOfCantidadListCantidad.getCantidadList().remove(cantidadListCantidad);
                    oldRecetaOfCantidadListCantidad = em.merge(oldRecetaOfCantidadListCantidad);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receta receta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Receta persistentReceta = em.find(Receta.class, receta.getCodReceta());
            List<Cantidad> cantidadListOld = persistentReceta.getCantidadList();
            List<Cantidad> cantidadListNew = receta.getCantidadList();
            List<String> illegalOrphanMessages = null;
            for (Cantidad cantidadListOldCantidad : cantidadListOld) {
                if (!cantidadListNew.contains(cantidadListOldCantidad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cantidad " + cantidadListOldCantidad + " since its receta field is not nullable.");
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
            receta.setCantidadList(cantidadListNew);
            receta = em.merge(receta);
            for (Cantidad cantidadListNewCantidad : cantidadListNew) {
                if (!cantidadListOld.contains(cantidadListNewCantidad)) {
                    Receta oldRecetaOfCantidadListNewCantidad = cantidadListNewCantidad.getReceta();
                    cantidadListNewCantidad.setReceta(receta);
                    cantidadListNewCantidad = em.merge(cantidadListNewCantidad);
                    if (oldRecetaOfCantidadListNewCantidad != null && !oldRecetaOfCantidadListNewCantidad.equals(receta)) {
                        oldRecetaOfCantidadListNewCantidad.getCantidadList().remove(cantidadListNewCantidad);
                        oldRecetaOfCantidadListNewCantidad = em.merge(oldRecetaOfCantidadListNewCantidad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = receta.getCodReceta();
                if (findReceta(id) == null) {
                    throw new NonexistentEntityException("The receta with id " + id + " no longer exists.");
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
            Receta receta;
            try {
                receta = em.getReference(Receta.class, id);
                receta.getCodReceta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The receta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cantidad> cantidadListOrphanCheck = receta.getCantidadList();
            for (Cantidad cantidadListOrphanCheckCantidad : cantidadListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Receta (" + receta + ") cannot be destroyed since the Cantidad " + cantidadListOrphanCheckCantidad + " in its cantidadList field has a non-nullable receta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(receta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receta> findRecetaEntities() {
        return findRecetaEntities(true, -1, -1);
    }

    public List<Receta> findRecetaEntities(int maxResults, int firstResult) {
        return findRecetaEntities(false, maxResults, firstResult);
    }

    private List<Receta> findRecetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receta.class));
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

    public Receta findReceta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receta> rt = cq.from(Receta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
      // Receta.findByNombreReceta
      // Método añadido, usando una named query de la entidad ingrediente
    public Receta findByNombreReceta(String nombre){
        EntityManager em = getEntityManager();
        // Se crea la query usando el nombre de la named query
        Query q = em.createNamedQuery("Receta.findByNombreReceta");
        // Se establece el parámetro de la consulta
        q.setParameter("nombreReceta", nombre);
        try {
            Object tmp =q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
        return (Receta)q.getSingleResult();
    }
    
        // Receta.findByNombreReceta
      // Método añadido, usando una named query de la entidad ingrediente
    public Receta findByCreador(Usuario usuario){
        EntityManager em = getEntityManager();
        // Se crea la query usando el nombre de la named query
        Query q = em.createNamedQuery("Receta.findByCreador");
        // Se establece el parámetro de la consulta
        q.setParameter("creador", usuario.getCodUsuario());
        try {
            Object tmp =q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
        return (Receta)q.getSingleResult();
    }
       
}

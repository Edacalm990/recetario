/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.Cantidad;
import entidades.CantidadPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Ingrediente;
import entidades.Receta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author eli
 */
public class CantidadJpaController implements Serializable {

    public CantidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cantidad cantidad) throws PreexistingEntityException, Exception {
        if (cantidad.getCantidadPK() == null) {
            cantidad.setCantidadPK(new CantidadPK());
        }
        cantidad.getCantidadPK().setCodIngrediente(cantidad.getIngrediente().getCodIngrediente());
        cantidad.getCantidadPK().setCodReceta(cantidad.getReceta().getCodReceta());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ingrediente ingrediente = cantidad.getIngrediente();
            if (ingrediente != null) {
                ingrediente = em.getReference(ingrediente.getClass(), ingrediente.getCodIngrediente());
                cantidad.setIngrediente(ingrediente);
            }
            Receta receta = cantidad.getReceta();
            if (receta != null) {
                receta = em.getReference(receta.getClass(), receta.getCodReceta());
                cantidad.setReceta(receta);
            }
            em.persist(cantidad);
            if (ingrediente != null) {
                ingrediente.getCantidadList().add(cantidad);
                ingrediente = em.merge(ingrediente);
            }
            if (receta != null) {
                receta.getCantidadList().add(cantidad);
                receta = em.merge(receta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCantidad(cantidad.getCantidadPK()) != null) {
                throw new PreexistingEntityException("Cantidad " + cantidad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cantidad cantidad) throws NonexistentEntityException, Exception {
        cantidad.getCantidadPK().setCodIngrediente(cantidad.getIngrediente().getCodIngrediente());
        cantidad.getCantidadPK().setCodReceta(cantidad.getReceta().getCodReceta());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cantidad persistentCantidad = em.find(Cantidad.class, cantidad.getCantidadPK());
            Ingrediente ingredienteOld = persistentCantidad.getIngrediente();
            Ingrediente ingredienteNew = cantidad.getIngrediente();
            Receta recetaOld = persistentCantidad.getReceta();
            Receta recetaNew = cantidad.getReceta();
            if (ingredienteNew != null) {
                ingredienteNew = em.getReference(ingredienteNew.getClass(), ingredienteNew.getCodIngrediente());
                cantidad.setIngrediente(ingredienteNew);
            }
            if (recetaNew != null) {
                recetaNew = em.getReference(recetaNew.getClass(), recetaNew.getCodReceta());
                cantidad.setReceta(recetaNew);
            }
            cantidad = em.merge(cantidad);
            if (ingredienteOld != null && !ingredienteOld.equals(ingredienteNew)) {
                ingredienteOld.getCantidadList().remove(cantidad);
                ingredienteOld = em.merge(ingredienteOld);
            }
            if (ingredienteNew != null && !ingredienteNew.equals(ingredienteOld)) {
                ingredienteNew.getCantidadList().add(cantidad);
                ingredienteNew = em.merge(ingredienteNew);
            }
            if (recetaOld != null && !recetaOld.equals(recetaNew)) {
                recetaOld.getCantidadList().remove(cantidad);
                recetaOld = em.merge(recetaOld);
            }
            if (recetaNew != null && !recetaNew.equals(recetaOld)) {
                recetaNew.getCantidadList().add(cantidad);
                recetaNew = em.merge(recetaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CantidadPK id = cantidad.getCantidadPK();
                if (findCantidad(id) == null) {
                    throw new NonexistentEntityException("The cantidad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CantidadPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cantidad cantidad;
            try {
                cantidad = em.getReference(Cantidad.class, id);
                cantidad.getCantidadPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cantidad with id " + id + " no longer exists.", enfe);
            }
            Ingrediente ingrediente = cantidad.getIngrediente();
            if (ingrediente != null) {
                ingrediente.getCantidadList().remove(cantidad);
                ingrediente = em.merge(ingrediente);
            }
            Receta receta = cantidad.getReceta();
            if (receta != null) {
                receta.getCantidadList().remove(cantidad);
                receta = em.merge(receta);
            }
            em.remove(cantidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cantidad> findCantidadEntities() {
        return findCantidadEntities(true, -1, -1);
    }

    public List<Cantidad> findCantidadEntities(int maxResults, int firstResult) {
        return findCantidadEntities(false, maxResults, firstResult);
    }

    private List<Cantidad> findCantidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cantidad.class));
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

    public Cantidad findCantidad(CantidadPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cantidad.class, id);
        } finally {
            em.close();
        }
    }
    

    public int getCantidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cantidad> rt = cq.from(Cantidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

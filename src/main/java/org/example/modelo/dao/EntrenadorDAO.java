package org.example.modelo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.entidades.Entrenador;

public class EntrenadorDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemonPU");

    public void crearEntrenador(Entrenador entrenador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(entrenador);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
    public Entrenador buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Entrenador.class, nombre);
        } finally {
            em.close();
        }
    }


    public void actualizarEntrenador(Entrenador entrenador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(entrenador);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void eliminarEntrenador(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Entrenador entrenador = em.find(Entrenador.class, id);
            if (entrenador != null) {
                em.remove(entrenador);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}

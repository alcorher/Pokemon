package org.example.modelo.dao;

import jakarta.persistence.*;
import org.example.modelo.entidades.Ataques;


public class AtaquesDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemonPU");

    public void crearAtaque(Ataques ataque) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ataque);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Ataques leerAtaque(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Ataques.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarAtaque(Ataques ataque) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ataque);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarAtaque(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Ataques ataque = em.find(Ataques.class, id);
            if (ataque != null) {
                em.remove(ataque);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}


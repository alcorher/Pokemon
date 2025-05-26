package org.example.modelo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.entidades.*;

import java.util.List;

public class PokemonDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemonPU");

    public List<Pokemon> buscarPorNivel(Integer nivel) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pokemon p WHERE p.nivel = :nivel", Pokemon.class)
                    .setParameter("nivel", nivel)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pokemon> buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pokemon p WHERE p.nombre = :nombre", Pokemon.class)
                    .setParameter("nombre", nombre)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pokemon> buscarPorTipo(Class<? extends Pokemon> tipo) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pokemon p WHERE TYPE(p) = :tipo", Pokemon.class)
                    .setParameter("tipo", tipo)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // Actualizar un Pokémon existente
    public void actualizarPokemon(Pokemon pokemon) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(pokemon);
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


    public void borrarPokemon(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Pokemon pokemon = em.find(Pokemon.class, id);
            if (pokemon != null) {
                em.remove(pokemon);
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


    public void crearPokemon(Pokemon pokemon) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            if (pokemon instanceof PokemonElectrico) {
                em.persist((PokemonElectrico) pokemon);
            } else if (pokemon instanceof PokemonFuego) {
                em.persist((PokemonFuego) pokemon);
            } else if (pokemon instanceof PokemonAgua) {
                em.persist((PokemonAgua) pokemon);
            } else {
                throw new IllegalArgumentException("Tipo de Pokémon no soportado");
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

    public List<Pokemon> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pokemon p", Pokemon.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Pokemon setEntrenador(Pokemon pokemon, Integer entrenadorId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Pokemon existingPokemon = em.find(Pokemon.class, pokemon.getId());
            if (existingPokemon != null) {
                existingPokemon.setEntrenador(em.find(Entrenador.class, entrenadorId));
                em.merge(existingPokemon);
                em.getTransaction().commit();
                return existingPokemon;
            } else {
                throw new IllegalArgumentException("Pokémon no encontrado con ID: " + pokemon.getId());
            }
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

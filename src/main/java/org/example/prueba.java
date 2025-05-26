package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class prueba {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemonPU");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Conexión exitosa a la base de datos!");
            // Puedes probar una consulta simple
            boolean tableExists = !em.createNativeQuery("SHOW TABLES").getResultList().isEmpty();
            System.out.println("Tablas existentes: " + tableExists);
            // Crear entrenadores y pokémons de ejemplo
            em.getTransaction().begin();

            org.example.modelo.entidades.Entrenador ash = new org.example.modelo.entidades.Entrenador();
            ash.setNombre("Ash");
            ash.setExperiencia(0);
            ash.setRegion("Kanto");
            org.example.modelo.entidades.Entrenador misty = new org.example.modelo.entidades.Entrenador();
            misty.setNombre("Misty");
            misty.setExperiencia(0);
            misty.setRegion("Kanto");

            org.example.modelo.entidades.Pokemon pikachu = new org.example.modelo.entidades.PokemonElectrico("Pikachu", 10, 35, 55, 40, 90, 100.0, 50);
            pikachu.setEntrenador(ash);
            org.example.modelo.entidades.Pokemon staryu = new org.example.modelo.entidades.PokemonAgua("Staryu", 10, 30, 45, 55, 85, 100, 50);
            staryu.setEntrenador(misty);

            ash.getPokemons().add(pikachu);
            misty.getPokemons().add(staryu);

            // Crear ataques y asignarlos a los pokémons
            org.example.modelo.entidades.Ataques impactoTrueno = new org.example.modelo.entidades.Ataques("Impactrueno", 40);
            impactoTrueno.setPokemon(pikachu);
            org.example.modelo.entidades.Ataques rayo = new org.example.modelo.entidades.Ataques("Rayo", 90);
            rayo.setPokemon(pikachu);

            org.example.modelo.entidades.Ataques pistolaAgua = new org.example.modelo.entidades.Ataques("Pistola Agua", 40);
            pistolaAgua.setPokemon(staryu);
            org.example.modelo.entidades.Ataques hidrobomba = new org.example.modelo.entidades.Ataques("Hidrobomba", 110);
            hidrobomba.setPokemon(staryu);

            em.persist(ash);
            em.persist(misty);
            em.persist(pikachu);
            em.persist(staryu);
            em.persist(impactoTrueno);
            em.persist(rayo);
            em.persist(pistolaAgua);
            em.persist(hidrobomba);

            em.getTransaction().commit();

            // Simular combate
            org.example.modelo.dao.CombatesDAO combatesDAO = new org.example.modelo.dao.CombatesDAO();
            combatesDAO.combatir(ash, misty);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
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
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
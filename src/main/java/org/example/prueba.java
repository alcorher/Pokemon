package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.entidades.*;
import org.example.modelo.dao.CombatesDAO;

import java.util.ArrayList;
import java.util.Arrays;

public class prueba {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemonPU");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Conexion exitosa a la base de datos!");

            em.getTransaction().begin();

            // Crear entrenadores
            Entrenador ash = new Entrenador("Ash", "Kanto", 150);
            Entrenador gary = new Entrenador("Gary", "Kanto", 180);
            Entrenador brock = new Entrenador("Brock", "Kanto", 120);

            // Crear pokémons para Ash
            PokemonElectrico pikachu = new PokemonElectrico("Pikachu", 25, 35, 55, 40, 90, 150.0, 80);
            PokemonFuego charizard = new PokemonFuego("Charizard", 30, 78, 84, 78, 100, 1200.0, 9);
            PokemonAgua squirtle = new PokemonAgua("Squirtle", 20, 44, 48, 65, 43, 85, 120);

            pikachu.setEntrenador(ash);
            charizard.setEntrenador(ash);
            squirtle.setEntrenador(ash);

            ash.setPokemons(new ArrayList<>(Arrays.asList(pikachu, charizard, squirtle)));

            // Crear pokémons para Gary
            PokemonElectrico jolteon = new PokemonElectrico("Jolteon", 28, 65, 65, 60, 130, 200.0, 95);
            PokemonFuego arcanine = new PokemonFuego("Arcanine", 32, 90, 110, 80, 95, 1100.0, 8);
            PokemonAgua blastoise = new PokemonAgua("Blastoise", 35, 79, 83, 100, 78, 95, 150);

            jolteon.setEntrenador(gary);
            arcanine.setEntrenador(gary);
            blastoise.setEntrenador(gary);

            gary.setPokemons(new ArrayList<>(Arrays.asList(jolteon, arcanine, blastoise)));

            // Crear pokémons para Brock
            PokemonElectrico raichu = new PokemonElectrico("Raichu", 26, 60, 90, 55, 110, 180.0, 75);
            PokemonFuego rapidash = new PokemonFuego("Rapidash", 29, 65, 100, 70, 105, 950.0, 7);

            raichu.setEntrenador(brock);
            rapidash.setEntrenador(brock);

            brock.setPokemons(new ArrayList<>(Arrays.asList(raichu, rapidash)));

            // Crear ataques para Pikachu
            Ataques impactrueno = new Ataques("Impactrueno", 40);
            Ataques rayo = new Ataques("Rayo", 90);
            Ataques ataqueRapido = new Ataques("Ataque Rapido", 40);
            Ataques trueno = new Ataques("Trueno", 110);

            impactrueno.setPokemon(pikachu);
            rayo.setPokemon(pikachu);
            ataqueRapido.setPokemon(pikachu);
            trueno.setPokemon(pikachu);

            pikachu.setAtaques(new ArrayList<>(Arrays.asList(impactrueno, rayo, ataqueRapido, trueno)));

            // Crear ataques para Charizard
            Ataques lanzallamas = new Ataques("Lanzallamas", 90);
            Ataques llamarada = new Ataques("Llamarada", 150);
            Ataques garra = new Ataques("Garra", 40);
            Ataques alaAcero = new Ataques("Ala de Acero", 70);

            lanzallamas.setPokemon(charizard);
            llamarada.setPokemon(charizard);
            garra.setPokemon(charizard);
            alaAcero.setPokemon(charizard);

            charizard.setAtaques(new ArrayList<>(Arrays.asList(lanzallamas, llamarada, garra, alaAcero)));

            // Crear ataques para Squirtle
            Ataques pistolaAgua = new Ataques("Pistola Agua", 40);
            Ataques hidrobomba = new Ataques("Hidrobomba", 110);
            Ataques burbuja = new Ataques("Burbuja", 40);
            Ataques surf = new Ataques("Surf", 90);

            pistolaAgua.setPokemon(squirtle);
            hidrobomba.setPokemon(squirtle);
            burbuja.setPokemon(squirtle);
            surf.setPokemon(squirtle);

            squirtle.setAtaques(new ArrayList<>(Arrays.asList(pistolaAgua, hidrobomba, burbuja, surf)));

            // Crear ataques para Jolteon
            Ataques puncaElectrica = new Ataques("Punca Electrica", 65);
            Ataques rayoCarga = new Ataques("Rayo Carga", 50);
            Ataques agilidad = new Ataques("Agilidad", 0); // Ataque de estado
            Ataques voltioFeroz = new Ataques("Voltio Feroz", 120);

            puncaElectrica.setPokemon(jolteon);
            rayoCarga.setPokemon(jolteon);
            agilidad.setPokemon(jolteon);
            voltioFeroz.setPokemon(jolteon);

            jolteon.setAtaques(new ArrayList<>(Arrays.asList(puncaElectrica, rayoCarga, agilidad, voltioFeroz)));

            // Crear ataques para Arcanine
            Ataques colmielloIgneo = new Ataques("Colmillo Igneo", 65);
            Ataques sofoco = new Ataques("Sofoco", 120);
            Ataques velocidadExtrema = new Ataques("Velocidad Extrema", 80);
            Ataques ondaIgnea = new Ataques("Onda Ignea", 95);

            colmielloIgneo.setPokemon(arcanine);
            sofoco.setPokemon(arcanine);
            velocidadExtrema.setPokemon(arcanine);
            ondaIgnea.setPokemon(arcanine);

            arcanine.setAtaques(new ArrayList<>(Arrays.asList(colmielloIgneo, sofoco, velocidadExtrema, ondaIgnea)));

            // Crear ataques para Blastoise
            Ataques canionAgua = new Ataques("Canon de Agua", 120);
            Ataques proteccion = new Ataques("Proteccion", 0);
            Ataques terremoto = new Ataques("Terremoto", 100);
            Ataques ventisca = new Ataques("Ventisca", 110);

            canionAgua.setPokemon(blastoise);
            proteccion.setPokemon(blastoise);
            terremoto.setPokemon(blastoise);
            ventisca.setPokemon(blastoise);

            blastoise.setAtaques(new ArrayList<>(Arrays.asList(canionAgua, proteccion, terremoto, ventisca)));

            // Crear ataques para Raichu
            Ataques punoTrueno = new Ataques("Puno Trueno", 75);
            Ataques ondaTrueno = new Ataques("Onda Trueno", 0);
            Ataques fuerza = new Ataques("Fuerza", 80);
            Ataques coletazo = new Ataques("Coletazo", 30);

            punoTrueno.setPokemon(raichu);
            ondaTrueno.setPokemon(raichu);
            fuerza.setPokemon(raichu);
            coletazo.setPokemon(raichu);

            raichu.setAtaques(new ArrayList<>(Arrays.asList(punoTrueno, ondaTrueno, fuerza, coletazo)));

            // Crear ataques para Rapidash
            Ataques patadaIgnea = new Ataques("Patada Ignea", 85);
            Ataques pisotazo = new Ataques("Pisotazo", 65);
            Ataques derribo = new Ataques("Derribo", 90);
            Ataques resplandor = new Ataques("Resplandor", 40);

            patadaIgnea.setPokemon(rapidash);
            pisotazo.setPokemon(rapidash);
            derribo.setPokemon(rapidash);
            resplandor.setPokemon(rapidash);

            rapidash.setAtaques(new ArrayList<>(Arrays.asList(patadaIgnea, pisotazo, derribo, resplandor)));

            // Persistir entidades
            em.persist(ash);
            em.persist(gary);
            em.persist(brock);

            // Persistir pokémons
            em.persist(pikachu);
            em.persist(charizard);
            em.persist(squirtle);
            em.persist(jolteon);
            em.persist(arcanine);
            em.persist(blastoise);
            em.persist(raichu);
            em.persist(rapidash);

            // Persistir todos los ataques
            em.persist(impactrueno);
            em.persist(rayo);
            em.persist(ataqueRapido);
            em.persist(trueno);
            em.persist(lanzallamas);
            em.persist(llamarada);
            em.persist(garra);
            em.persist(alaAcero);
            em.persist(pistolaAgua);
            em.persist(hidrobomba);
            em.persist(burbuja);
            em.persist(surf);
            em.persist(puncaElectrica);
            em.persist(rayoCarga);
            em.persist(agilidad);
            em.persist(voltioFeroz);
            em.persist(colmielloIgneo);
            em.persist(sofoco);
            em.persist(velocidadExtrema);
            em.persist(ondaIgnea);
            em.persist(canionAgua);
            em.persist(proteccion);
            em.persist(terremoto);
            em.persist(ventisca);
            em.persist(punoTrueno);
            em.persist(ondaTrueno);
            em.persist(fuerza);
            em.persist(coletazo);
            em.persist(patadaIgnea);
            em.persist(pisotazo);
            em.persist(derribo);
            em.persist(resplandor);

            em.getTransaction().commit();

            System.out.println("Datos insertados correctamente!");
            System.out.println();

            // Mostrar información de los entrenadores
            System.out.println("=== INFORMACION DE ENTRENADORES ===");
            mostrarEntrenador(ash);
            mostrarEntrenador(gary);
            mostrarEntrenador(brock);

            System.out.println();

            // Simular combates
            CombatesDAO combatesDAO = new CombatesDAO();

            System.out.println("COMBATE 1:");
            combatesDAO.combatir(ash, gary);

            System.out.println("\n" + "=".repeat(60) + "\n");

            System.out.println("COMBATE 2:");
            combatesDAO.combatir(gary, brock);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void mostrarEntrenador(Entrenador entrenador) {
        System.out.println("Entrenador: " + entrenador.getNombre() +
                " | Region: " + entrenador.getRegion() +
                " | Experiencia: " + entrenador.getExperiencia());
        System.out.println("Pokemons:");
        for (Pokemon pokemon : entrenador.getPokemons()) {
            System.out.println("  - " + pokemon.getNombre() +
                    " (Nv." + pokemon.getNivel() +
                    " | HP:" + pokemon.getHp() +
                    " | Atq:" + pokemon.getAtaque() +
                    " | Def:" + pokemon.getDefensa() +
                    " | Vel:" + pokemon.getVelocidad() +
                    " | Potencial:" + String.format("%.1f", pokemon.calcularPotencialAtaque()) + ")");
            System.out.println("    Ataques:");
            for (Ataques ataque : pokemon.getAtaques()) {
                System.out.println("      * " + ataque.getNombre() + " (Potencia: " + ataque.getPotencia() + ")");
            }
        }
        System.out.println();
    }
}
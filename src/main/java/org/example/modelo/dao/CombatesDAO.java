package org.example.modelo.dao;

import org.example.modelo.entidades.Entrenador;
import org.example.modelo.entidades.Pokemon;
import org.example.modelo.entidades.Ataques;

import java.util.List;

public class CombatesDAO {

    private void atacar(Pokemon atacante, Pokemon defensor) {
        if (atacante.getAtaques() == null || atacante.getAtaques().isEmpty()) {
            System.out.println(atacante.getNombre() + " no tiene ataques para usar.");
            return;
        }

        // Seleccionar ataque aleatorio
        Ataques ataqueSeleccionado = atacante.getAtaques()
                .get((int) (Math.random() * atacante.getAtaques().size()));

        // Calcular daño mejorado considerando nivel
        double potenciaAtacante = atacante.calcularPotencialAtaque();
        double multiplicadorNivel = 1.0 + (atacante.getNivel() * 0.05); // 5% por nivel
        double defensaEfectiva = defensor.getDefensa() * (1.0 + defensor.getNivel() * 0.03); // 3% por nivel

        // Fórmula de daño balanceada
        int danoBase = (int) ((potenciaAtacante + ataqueSeleccionado.getPotencia()) * multiplicadorNivel);
        int danoFinal = Math.max(1, danoBase - (int)(defensaEfectiva * 0.7)); // La defensa reduce 70% de su valor

        // Aplicar multiplicador de vida para combates más largos
        int vidaActual = defensor.getHp();
        int nuevaVida = Math.max(0, vidaActual - danoFinal);
        defensor.setHp(nuevaVida);

        System.out.println(atacante.getNombre() + " (Nv." + atacante.getNivel() + ") usa " +
                ataqueSeleccionado.getNombre() + " contra " + defensor.getNombre() +
                " (Nv." + defensor.getNivel() + ")");
        System.out.println("Dano infligido: " + danoFinal + " | Vida restante: " + nuevaVida + " HP");
        System.out.println("----------------------------------------");
    }

    public void combatir(Entrenador entrenador1, Entrenador entrenador2) {
        System.out.println("=== COMIENZA EL COMBATE ===");
        System.out.println(entrenador1.getNombre() + " vs " + entrenador2.getNombre());
        System.out.println();

        // Aplicar multiplicador de vida para combates más largos
        aplicarMultiplicadorVida(entrenador1, 2.5);
        aplicarMultiplicadorVida(entrenador2, 2.5);

        List<Pokemon> vivos1 = entrenador1.getPokemons().stream().filter(p -> p.getHp() > 0).toList();
        List<Pokemon> vivos2 = entrenador2.getPokemons().stream().filter(p -> p.getHp() > 0).toList();

        if (vivos1.isEmpty() || vivos2.isEmpty()) {
            System.out.println("Algun entrenador no tiene pokemons vivos para combatir.");
            return;
        }

        Pokemon actual1 = vivos1.get(0); // Empezar con el primer pokemon
        Pokemon actual2 = vivos2.get(0);

        System.out.println(entrenador1.getNombre() + " envia a " + actual1.getNombre() + " (HP: " + actual1.getHp() + ")");
        System.out.println(entrenador2.getNombre() + " envia a " + actual2.getNombre() + " (HP: " + actual2.getHp() + ")");
        System.out.println();

        boolean turnoEntrenador1 = determinarPrioridad(actual1, actual2);
        int turno = 1;

        while (entrenador1.getPokemons().stream().anyMatch(p -> p.getHp() > 0) &&
                entrenador2.getPokemons().stream().anyMatch(p -> p.getHp() > 0)) {

            System.out.println("--- Turno " + turno + " ---");

            if (turnoEntrenador1) {
                atacar(actual1, actual2);
                if (actual2.getHp() <= 0) {
                    System.out.println(actual2.getNombre() + " ha sido derrotado!");
                    List<Pokemon> vivosRestantes = entrenador2.getPokemons().stream()
                            .filter(p -> p.getHp() > 0).toList();
                    if (vivosRestantes.isEmpty()) {
                        break;
                    }
                    actual2 = vivosRestantes.get(0);
                    System.out.println(entrenador2.getNombre() + " envia a " + actual2.getNombre() +
                            " (HP: " + actual2.getHp() + ")");
                }
            } else {
                atacar(actual2, actual1);
                if (actual1.getHp() <= 0) {
                    System.out.println(actual1.getNombre() + " ha sido derrotado!");
                    List<Pokemon> vivosRestantes = entrenador1.getPokemons().stream()
                            .filter(p -> p.getHp() > 0).toList();
                    if (vivosRestantes.isEmpty()) {
                        break;
                    }
                    actual1 = vivosRestantes.get(0);
                    System.out.println(entrenador1.getNombre() + " envia a " + actual1.getNombre() +
                            " (HP: " + actual1.getHp() + ")");
                }
            }

            turnoEntrenador1 = !turnoEntrenador1;
            turno++;

            // Pequeña pausa visual
            if (turno % 4 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("=== FIN DEL COMBATE ===");
        if (entrenador1.getPokemons().stream().anyMatch(p -> p.getHp() > 0)) {
            System.out.println("GANADOR: " + entrenador1.getNombre());
            entrenador1.setExperiencia(entrenador1.getExperiencia() + 100);
        } else {
            System.out.println("GANADOR: " + entrenador2.getNombre());
            entrenador2.setExperiencia(entrenador2.getExperiencia() + 100);
        }
    }

    private void aplicarMultiplicadorVida(Entrenador entrenador, double multiplicador) {
        for (Pokemon pokemon : entrenador.getPokemons()) {
            int vidaOriginal = pokemon.getHp();
            int nuevaVida = (int) (vidaOriginal * multiplicador);
            pokemon.setHp(nuevaVida);
        }
    }

    private boolean determinarPrioridad(Pokemon pokemon1, Pokemon pokemon2) {
        // El pokemon con mayor velocidad ataca primero
        if (pokemon1.getVelocidad() > pokemon2.getVelocidad()) {
            return true;
        } else if (pokemon2.getVelocidad() > pokemon1.getVelocidad()) {
            return false;
        } else {
            // Si tienen la misma velocidad, aleatorio
            return Math.random() < 0.5;
        }
    }
}
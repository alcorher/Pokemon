package org.example.modelo.dao;

import org.example.modelo.entidades.Entrenador;
import org.example.modelo.entidades.Pokemon;

import java.util.List;

public class CombatesDAO {

    private void atacar(Pokemon atacante, Pokemon defensor) {
        if (atacante.getAtaques() == null || atacante.getAtaques().isEmpty()) {
            System.out.println(atacante.getNombre() + " no tiene ataques para usar.");
            return;
        }

        org.example.modelo.entidades.Ataques ataque = atacante.getAtaques()
                .get((int) (Math.random() * atacante.getAtaques().size()));

        // Cálculo de daño más balanceado
        // Reducimos significativamente el impacto del potencial de ataque y la potencia del ataque
        double danoBase = (atacante.getAtaque() * 0.3) + (ataque.getPotencia() * 0.2);
        double danoFinal = Math.max(1, danoBase - (defensor.getDefensa() * 0.2));

        int vidaRestante = defensor.getHp() - (int) Math.ceil(danoFinal);
        defensor.setHp(Math.max(0, vidaRestante));

        System.out.println(atacante.getNombre() + " usa " + ataque.getNombre() +
                " contra " + defensor.getNombre() + " causando " + (int) Math.ceil(danoFinal) +
                " de daño. " + defensor.getNombre() + " tiene " + defensor.getHp() + " HP restantes.");
    }

    public void combatir(Entrenador entrenador1, Entrenador entrenador2) {

        List<Pokemon> vivos1 = entrenador1.getPokemons().stream().filter(p -> p.getHp() > 0).toList();
        List<Pokemon> vivos2 = entrenador2.getPokemons().stream().filter(p -> p.getHp() > 0).toList();

        if (vivos1.isEmpty() || vivos2.isEmpty()) {
            System.out.println("Algún entrenador no tiene pokémons vivos.");
            return;
        }

        Pokemon actual1 = vivos1.get((int) (Math.random() * vivos1.size()));
        Pokemon actual2 = vivos2.get((int) (Math.random() * vivos2.size()));

        System.out.println("¡Comienza el combate!");
        System.out.println(entrenador1.getNombre() + " usa a " + actual1.getNombre() + " (HP: " + actual1.getHp() + ")");
        System.out.println(entrenador2.getNombre() + " usa a " + actual2.getNombre() + " (HP: " + actual2.getHp() + ")");
        System.out.println("---");

        boolean turnoEntrenador1 = true;
        int turno = 1;

        while (entrenador1.getPokemons().stream().anyMatch(p -> p.getHp() > 0) &&
                entrenador2.getPokemons().stream().anyMatch(p -> p.getHp() > 0)) {

            System.out.println("Turno " + turno + ":");

            if (turnoEntrenador1) {
                atacar(actual1, actual2);
                if (actual2.getHp() <= 0) {
                    System.out.println(actual2.getNombre() + " ha sido derrotado!");
                    List<Pokemon> vivos = entrenador2.getPokemons().stream().filter(p -> p.getHp() > 0).toList();
                    if (vivos.isEmpty()) break;
                    actual2 = vivos.get((int) (Math.random() * vivos.size()));
                    System.out.println(entrenador2.getNombre() + " envía a " + actual2.getNombre() + " (HP: " + actual2.getHp() + ")");
                }
            } else {
                atacar(actual2, actual1);
                if (actual1.getHp() <= 0) {
                    System.out.println(actual1.getNombre() + " ha sido derrotado!");
                    List<Pokemon> vivos = entrenador1.getPokemons().stream().filter(p -> p.getHp() > 0).toList();
                    if (vivos.isEmpty()) break;
                    actual1 = vivos.get((int) (Math.random() * vivos.size()));
                    System.out.println(entrenador1.getNombre() + " envía a " + actual1.getNombre() + " (HP: " + actual1.getHp() + ")");
                }
            }

            turnoEntrenador1 = !turnoEntrenador1;
            turno++;
            System.out.println("---");
        }

        System.out.println("¡Fin del combate!");
        if (entrenador1.getPokemons().stream().anyMatch(p -> p.getHp() > 0)) {
            System.out.println("🏆 " + entrenador1.getNombre() + " gana el combate!");
        } else {
            System.out.println("🏆 " + entrenador2.getNombre() + " gana el combate!");
        }
    }
}
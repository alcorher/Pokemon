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
    int vidaRestante = defensor.getHp() - (atacante.calcularPotencialAtaque().intValue() + ataque.getPotencia() - defensor.getDefensa());
    defensor.setHp(Math.max(0, vidaRestante));
    System.out.println(atacante.getNombre() + " usa " + ataque.getNombre() + " contra " + defensor.getNombre() +
            " y le deja con " + defensor.getHp() + " HP.");
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

        boolean turnoEntrenador1 = true;

        while (entrenador1.getPokemons().stream().anyMatch(p -> p.getHp() > 0) &&
                entrenador2.getPokemons().stream().anyMatch(p -> p.getHp() > 0)) {

            if (turnoEntrenador1) {
                atacar(actual1, actual2);
                int vidaRestante2 = actual2.getHp();
                if (vidaRestante2 <= 0) {
                    List<Pokemon> vivos = entrenador2.getPokemons().stream().filter(p -> p.getHp() > 0).toList();
                    if (vivos.isEmpty()) break;
                    actual2 = vivos.get((int) (Math.random() * vivos.size()));
                }
            } else {
                atacar(actual2, actual1);
                int vidaRestante1 = actual1.getHp();
                if (vidaRestante1 <= 0) {
                    List<Pokemon> vivos = entrenador1.getPokemons().stream().filter(p -> p.getHp() > 0).toList();
                    if (vivos.isEmpty()) break;
                    actual1 = vivos.get((int) (Math.random() * vivos.size()));
                }
            }
            turnoEntrenador1 = !turnoEntrenador1;
        }

        if (entrenador1.getPokemons().stream().anyMatch(p -> p.getHp() > 0)) {
            System.out.println(entrenador1.getNombre() + " gana el combate.");
        } else {
            System.out.println(entrenador2.getNombre() + " gana el combate.");
        }
    }

}
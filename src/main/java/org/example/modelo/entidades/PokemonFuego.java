// PokemonFuego.java
package org.example.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon_fuego")
public class PokemonFuego extends Pokemon {

    @Column(name = "temperatura_corporal", nullable = false)
    private Double temperaturaCorporal; // en grados Celsius

    @Column(name = "resistencia_calor", nullable = false)
    private Integer resistenciaCalor; // escala de 1-10

    // Constructores
    public PokemonFuego() {
        super();
    }

    public PokemonFuego(String nombre, Integer nivel, Integer hp, Integer ataque,
                        Integer defensa, Integer velocidad, Double temperaturaCorporal,
                        Integer resistenciaCalor) {
        super(nombre, nivel, hp, ataque, defensa, velocidad);
        this.temperaturaCorporal = temperaturaCorporal;
        this.resistenciaCalor = resistenciaCalor;
    }

    // Implementación del método abstracto
    @Override
    public Double calcularPotencialAtaque() {
        return getAtaque() * (getNivel() / 10.0) + temperaturaCorporal * 0.1 + resistenciaCalor * 0.5;
    }



    // Getters y Setters
    public Double getTemperaturaCorporal() { return temperaturaCorporal; }
    public void setTemperaturaCorporal(Double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }
    public Integer getResistenciaCalor() { return resistenciaCalor; }
    public void setResistenciaCalor(Integer resistenciaCalor) {
        this.resistenciaCalor = resistenciaCalor;
    }

    @Override
    public String toString() {
        return super.toString() + ", PokemonFuego [temperaturaCorporal=" +
                temperaturaCorporal + ", resistenciaCalor=" + resistenciaCalor + "]";
    }
}


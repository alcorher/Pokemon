package org.example.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon_electrico")
public class PokemonElectrico extends Pokemon {

    @Column(nullable = false)
    private Double voltaje;

    @Column(name = "capacidad_carga", nullable = false)
    private Integer capacidadCarga;

    // Constructores
    public PokemonElectrico() {
        super();
    }

    public PokemonElectrico(String nombre, Integer nivel, Integer hp, Integer ataque,
                            Integer defensa, Integer velocidad, Double voltaje,
                            Integer capacidadCarga) {
        super(nombre, nivel, hp, ataque, defensa, velocidad);
        this.voltaje = voltaje;
        this.capacidadCarga = capacidadCarga;
    }

    // Implementación del método abstracto
    @Override
    public Double calcularPotencialAtaque() {
        return getAtaque() * (getNivel() / 10.0) + voltaje * 0.5 + capacidadCarga * 0.2;
    }


    // Getters y Setters
    public Double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(Double voltaje) {
        this.voltaje = voltaje;
    }

    public Integer getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Integer capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", PokemonElectrico [voltaje=" +
                voltaje + ", capacidadCarga=" + capacidadCarga + "]";
    }
}
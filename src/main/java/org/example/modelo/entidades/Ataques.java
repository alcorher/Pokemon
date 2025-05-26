package org.example.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "ataques")
public class Ataques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private Integer potencia;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    public Ataques() {}

    public Ataques(String nombre, Integer potencia) {
        this.nombre = nombre;
        this.potencia = potencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
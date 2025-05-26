package org.example.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon_agua")
public class PokemonAgua extends Pokemon {

    @Column(name = "habilidades_nado", nullable = false)
    private Integer habilidadesNado;

    @Column(name = "tiempo_bajo_agua", nullable = false)
    private Integer tiempoBajoAgua;

    // Constructores
    public PokemonAgua() {
        super();
    }

    public PokemonAgua(String nombre, Integer nivel, Integer hp, Integer ataque,
                       Integer defensa, Integer velocidad, Integer habilidadesNado,
                       Integer tiempoBajoAgua) {
        super(nombre, nivel, hp, ataque, defensa, velocidad);
        this.habilidadesNado = habilidadesNado;
        this.tiempoBajoAgua = tiempoBajoAgua;
    }

    // Implementación del método abstracto
    @Override
    public Double calcularPotencialAtaque() {
        return getAtaque() * getNivel()/10.0 + habilidadesNado * 0.5 + tiempoBajoAgua * 0.2;
    }


    // Getters y Setters
    public Integer getHabilidadesNado() {
        return habilidadesNado;
    }
    public void setHabilidadesNado(Integer habilidadesNado) {
        this.habilidadesNado = habilidadesNado;
    }
    public Integer getTiempoBajoAgua() {
        return tiempoBajoAgua;
    }
    public void setTiempoBajoAgua(Integer tiempoBajoAgua) {
        this.tiempoBajoAgua = tiempoBajoAgua;
    }
    @Override
    public String toString() {
        return "PokemonAgua{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", nivel=" + getNivel() +
                ", hp=" + getHp() +
                ", ataque=" + getAtaque() +
                ", defensa=" + getDefensa() +
                ", velocidad=" + getVelocidad() +
                ", habilidadesNado=" + habilidadesNado +
                ", tiempoBajoAgua=" + tiempoBajoAgua +
                '}';
    }



}
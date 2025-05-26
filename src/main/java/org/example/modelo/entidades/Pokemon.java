package org.example.modelo.entidades;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pokemon")
public abstract class Pokemon{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private Integer nivel;

    @Column(name = "puntos_salud", nullable = false)
    private Integer hp;

    @Column(nullable = false)
    private Integer ataque;

    @Column(nullable = false)
    private Integer defensa;

    @Column(nullable = false)
    private Integer velocidad;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @OneToMany
    @JoinColumn(name = "pokemon_id")
    private java.util.List<Ataques> ataques;

    // Método polimórfico
    public abstract Double calcularPotencialAtaque();

    // Constructores
    public Pokemon() {}

    public Pokemon(String nombre, Integer nivel, Integer hp, Integer ataque,
                   Integer defensa, Integer velocidad) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getNivel() { return nivel; }
    public void setNivel(Integer nivel) { this.nivel = nivel; }
    public Integer getHp() { return hp; }
    public void setHp(Integer hp) { this.hp = hp; }
    public Integer getAtaque() { return ataque; }
    public void setAtaque(Integer ataque) { this.ataque = ataque; }
    public Integer getDefensa() { return defensa; }
    public void setDefensa(Integer defensa) { this.defensa = defensa; }
    public Integer getVelocidad() { return velocidad; }
    public void setVelocidad(Integer velocidad) { this.velocidad = velocidad; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public java.util.List<Ataques> getAtaques() { return ataques; }
    public void setAtaques(java.util.List<Ataques> ataques) { this.ataques = ataques; }

    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", nombre=" + nombre + ", nivel=" + nivel +
                ", hp=" + hp + ", ataque=" + ataque + ", defensa=" + defensa +
                ", velocidad=" + velocidad + "]";
    }
}
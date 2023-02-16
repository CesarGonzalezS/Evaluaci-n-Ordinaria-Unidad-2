package mx.edu.utez.bdPokemon.models.pokemons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.bdPokemon.models.entranadores.Entrenadores;

import javax.persistence.*;

@Entity
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false, length = 150)
        private String name;
        @Column(nullable = false, length = 150)
        private String type;
        @Column(nullable = false)
        private int power;
        @Column(nullable = false)
        private int health;
        @Column(nullable = false)
        private int damage;
        @Column(nullable = false)
        private int defense;
        @ManyToOne
        @JoinColumn(name = "entrenadores_id", nullable = false)
        private Entrenadores entrenadores;
}


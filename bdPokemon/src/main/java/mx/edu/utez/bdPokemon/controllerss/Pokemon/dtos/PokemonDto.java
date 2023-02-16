package mx.edu.utez.bdPokemon.controllerss.Pokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.bdPokemon.models.entranadores.Entrenadores;
import mx.edu.utez.bdPokemon.models.pokemons.Pokemon;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private long id;
    private String name;
    private String type;
    private int power;
    private int health;
    private int damage;
    private int defense;
    private Entrenadores Entrenador;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getName(),
                getType(),
                getPower(),
                getHealth(),
                getDamage(),
                getDefense(),
                getEntrenador()
        );
    }
   }


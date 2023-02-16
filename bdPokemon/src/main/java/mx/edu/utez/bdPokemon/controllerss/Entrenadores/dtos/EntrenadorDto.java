package mx.edu.utez.bdPokemon.controllerss.Entrenadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.bdPokemon.models.entranadores.Entrenadores;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntrenadorDto {
    private long id;
    private String name;
    private String team;

    public Entrenadores entrenadores(){
        return new Entrenadores(
                getId(),
                getName(),
                getTeam(),
                null
        );
    }
}

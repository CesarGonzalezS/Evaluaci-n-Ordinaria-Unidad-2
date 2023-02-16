package mx.edu.utez.bdPokemon.models.entranadores;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrenadoresRespository extends JpaRepository<Entrenadores, Long>  {
    Optional<Entrenadores> findByName(String name);
}


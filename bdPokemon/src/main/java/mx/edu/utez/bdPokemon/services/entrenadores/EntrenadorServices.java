package mx.edu.utez.bdPokemon.services.entrenadores;

import mx.edu.utez.bdPokemon.models.entranadores.Entrenadores;
import mx.edu.utez.bdPokemon.models.entranadores.EntrenadoresRespository;
import mx.edu.utez.bdPokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadorServices {

    @Autowired
    private EntrenadoresRespository repository;

    @Transactional(readOnly = true)
    public Response<List<Entrenadores>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<Entrenadores>getOne(Long id){
        if (this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Entrenador no encontrado"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> insert(Entrenadores entrenadores){
        Optional<Entrenadores> exists=this.repository.findByName(entrenadores.getName());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "El entrenador ya se encuentra registrado"
            );
        return new Response<>(
                this.repository.saveAndFlush(entrenadores),
                false,
                200,
                "Entrenador registrado"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> update(Entrenadores trainer, long id){
        if (!this.repository.existsById(id))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El entrenador no se encontró"
            );


        return new Response<>(
                this.repository.saveAndFlush(trainer),
                false,
                200,
                "Entrenador actualizado correctamente"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(Long id){
        if (!this.repository.existsById(id))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El entrenador no se encontró"
            );
        this.repository.deleteById(id);
        return new Response<>(
                null,
                false,
                200,
                "Entrenador eliminado correctamente"
        );

    }
}

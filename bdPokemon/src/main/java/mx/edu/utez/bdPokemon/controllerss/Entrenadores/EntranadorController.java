package mx.edu.utez.bdPokemon.controllerss.Entrenadores;

import mx.edu.utez.bdPokemon.controllerss.Entrenadores.dtos.EntrenadorDto;
import mx.edu.utez.bdPokemon.models.entranadores.Entrenadores;
import mx.edu.utez.bdPokemon.services.entrenadores.EntrenadorServices;
import mx.edu.utez.bdPokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokemon/trainer")
@CrossOrigin(origins = {"*"})
public class EntranadorController {
    @Autowired
    private EntrenadorServices service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenadores>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>getOne(@PathVariable long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Entrenadores>>insert(
            @RequestBody EntrenadorDto trainer
    ){
        return new ResponseEntity<>(
                this.service.insert(trainer.entrenadores()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>update(@PathVariable long id ,@RequestBody EntrenadorDto trainer){

        return new ResponseEntity<>(
                this.service.update(trainer.entrenadores(),id),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>delete(@PathVariable long id){
        this.service.delete(id);
        return new ResponseEntity<>(
                null,
                HttpStatus.CREATED
        );
    }
}

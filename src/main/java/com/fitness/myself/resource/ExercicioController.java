package com.fitness.myself.resource;

import com.fitness.myself.domain.DTO.response.ExercicioDTO;
import com.fitness.myself.domain.treino.Exercicio;
import com.fitness.myself.services.ExercicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/exercicio")
public class ExercicioController extends GenericController<ExercicioService>{

    public ExercicioController(ExercicioService service) {
        super(service);
    }

    @PostMapping()
    public ResponseEntity<ExercicioDTO> insertExercicio(@RequestBody Exercicio obj) {
        Exercicio exercicio = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(exercicio.getId()).toUri();
        return ResponseEntity.created(uri).body(getService().toExercicioDTO(exercicio));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExercicioDTO> findExercicioById(@PathVariable Long id) {
        Exercicio aluno = getService().findById(id);
        return ResponseEntity.ok(getService().toExercicioDTO(aluno));
    }

    @GetMapping
    public ResponseEntity<List<ExercicioDTO>> getAllExercicios() {
        return ResponseEntity.ok(getService().findlAllExercicios());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteExercicioById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

}

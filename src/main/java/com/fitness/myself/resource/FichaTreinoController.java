package com.fitness.myself.resource;

import com.fitness.myself.domain.DTO.response.FichaTreinoDTO;
import com.fitness.myself.domain.treino.FichaTreino;
import com.fitness.myself.services.FichaTreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/fichaTreino")
public class FichaTreinoController extends GenericController<FichaTreinoService>{

    public FichaTreinoController(FichaTreinoService service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<FichaTreinoDTO> insertFichaTreino(@RequestBody FichaTreino obj, @RequestHeader Long personalId, @RequestHeader Long alunoId) {
        FichaTreino fichaTreino = getService().insertFichaTreino(obj, personalId, alunoId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fichaTreino.getId()).toUri();
        return ResponseEntity.created(uri).body(getService().toFichaTreinoDTO(fichaTreino));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FichaTreinoDTO> findFichaTreinoById(@PathVariable Long id) {
        FichaTreino fichaTreino = getService().findById(id);
        return ResponseEntity.ok(getService().toFichaTreinoDTO(fichaTreino));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFichaTreinoById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity adicionarExercicioFicha(@PathVariable Long id, @RequestBody List<Long> ids) {
        getService().adicionarExerciciosALista(id, ids);
        return ResponseEntity.noContent().build();
    }

}

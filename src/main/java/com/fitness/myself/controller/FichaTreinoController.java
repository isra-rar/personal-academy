package com.fitness.myself.controller;

import com.fitness.myself.domain.DTO.FichaTreinoDTO;
import com.fitness.myself.domain.treino.FichaTreino;
import com.fitness.myself.services.FichaTreinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/fichaTreino")
public class FichaTreinoController extends GenericController<FichaTreinoService>{

    @PostMapping()
    public ResponseEntity<FichaTreinoDTO> insertFichaTreino(@RequestBody FichaTreino obj) {
        FichaTreino fichaTreino = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fichaTreino.getId()).toUri();
        return ResponseEntity.created(uri).body(getService().toFichaTreinoDTO(fichaTreino));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FichaTreinoDTO> findAlunoById(@PathVariable Long id) {
        FichaTreino fichaTreino = getService().findById(id);
        return ResponseEntity.ok(getService().toFichaTreinoDTO(fichaTreino));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFichaTreinoById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

}

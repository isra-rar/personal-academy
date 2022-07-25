package com.fitness.myself.controller;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.services.IAlunoService;
import com.fitness.myself.services.IPersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/aluno")
public class AlunoController extends GenericController<IAlunoService>{

    @PostMapping()
    public ResponseEntity<Aluno> insertAluno(@RequestBody Aluno obj) {
        Aluno aluno = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findAlunoById(@PathVariable Long id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAlunoById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}

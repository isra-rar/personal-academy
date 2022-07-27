package com.fitness.myself.controller;

import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.DTO.PersonalDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.services.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/aluno")
public class AlunoController extends GenericController<AlunoService>{

    @PostMapping()
    public ResponseEntity<AlunoDTO> insertAluno(@RequestBody Aluno obj) {
        Aluno aluno = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(getService().toAlunoDTO(aluno));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findAlunoById(@PathVariable Long id) {
        Aluno aluno = getService().findById(id);
        return ResponseEntity.ok(getService().toAlunoDTO(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAllAlunos() {
        return ResponseEntity.ok(getService().findlAllAlunos());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAlunoById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{alunoId}")
    public ResponseEntity atribuirPersonalAluno(@PathVariable Long alunoId, @RequestHeader Long personalId) {
        getService().atribuirAluno(alunoId, personalId);
        return ResponseEntity.noContent().build();
    }
}

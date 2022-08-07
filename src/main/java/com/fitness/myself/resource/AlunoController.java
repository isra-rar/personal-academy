package com.fitness.myself.resource;

import com.fitness.myself.domain.DTO.request.AlunoRequestDTO;
import com.fitness.myself.domain.DTO.response.AlunoResponseDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/aluno")
public class AlunoController extends GenericController<AlunoService>{

    public AlunoController(AlunoService service) {
        super(service);
    }

    @PostMapping()
    public ResponseEntity<AlunoResponseDTO> insertAluno(@RequestBody AlunoRequestDTO obj) {
        AlunoResponseDTO aluno = getService().insertAluno(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoResponseDTO> findAlunoById(@PathVariable Long id) {
        Aluno aluno = getService().findById(id);
        return ResponseEntity.ok(getService().toAlunoDTO(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAllAlunos() {
        return ResponseEntity.ok(getService().findlAllAlunos());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAlunoById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}

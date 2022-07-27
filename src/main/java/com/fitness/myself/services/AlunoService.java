package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.aluno.Aluno;

import java.util.List;

public interface AlunoService extends GenericService<Aluno> {

    Aluno insertAluno(Aluno obj, Long personalId);

    AlunoDTO toAlunoDTO(Aluno aluno);
    Aluno toAluno(AlunoDTO alunoDTO);

    List<AlunoDTO> findlAllAlunos();

}

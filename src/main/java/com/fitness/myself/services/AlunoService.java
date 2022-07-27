package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.aluno.Aluno;

public interface AlunoService extends GenericService<Aluno> {

    void atribuirAluno(Long alunoId, Long personalId);

    AlunoDTO toAlunoDTO(Aluno aluno);
    Aluno toAluno(AlunoDTO alunoDTO);
}

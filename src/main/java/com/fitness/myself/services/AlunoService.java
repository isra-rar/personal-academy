package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.request.AlunoRequestDTO;
import com.fitness.myself.domain.DTO.response.AlunoResponseDTO;
import com.fitness.myself.domain.aluno.Aluno;

import java.util.List;

public interface AlunoService extends GenericService<Aluno> {

    AlunoResponseDTO insertAluno(AlunoRequestDTO obj);

    AlunoResponseDTO toAlunoDTO(Aluno aluno);

    List<AlunoResponseDTO> findlAllAlunos();

}

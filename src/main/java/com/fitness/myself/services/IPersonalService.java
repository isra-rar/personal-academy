package com.fitness.myself.services;


import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;

public interface IPersonalService extends IGenericService<Personal> {

    void atribuirAluno(Long personalId, Long alunoId);

}

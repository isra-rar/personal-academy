package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.FichaTreinoDTO;
import com.fitness.myself.domain.treino.FichaTreino;

import java.util.List;

public interface FichaTreinoService extends GenericService<FichaTreino>{

    FichaTreino insertFichaTreino(FichaTreino entity, Long personalId, Long alunoId);
    FichaTreinoDTO toFichaTreinoDTO(FichaTreino fichaTreino);

    void adicionarExerciciosALista(Long idFicha, List<Long> ids);
}

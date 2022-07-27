package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.FichaTreinoDTO;
import com.fitness.myself.domain.treino.FichaTreino;

public interface FichaTreinoService extends GenericService<FichaTreino>{
    FichaTreinoDTO toFichaTreinoDTO(FichaTreino fichaTreino);
}

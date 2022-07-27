package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.FichaTreinoDTO;
import com.fitness.myself.domain.treino.FichaTreino;
import com.fitness.myself.repositories.IFichaTreinoRepository;
import com.fitness.myself.services.FichaTreinoService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FichaTreinoServiceImpl extends GenericServiceImpl<IFichaTreinoRepository> implements FichaTreinoService {

    @Override
    public FichaTreino insert(FichaTreino entity) {
        return getRepository().save(entity);
    }

    @Override
    public FichaTreino findById(Long id) {
        Optional<FichaTreino> fichaTreino = getRepository().findById(id);
        return fichaTreino.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        FichaTreino fichaTreino = findById(id);
        getRepository().delete(fichaTreino);
    }

    @Override
    public FichaTreinoDTO toFichaTreinoDTO(FichaTreino fichaTreino) {
        return modelMapper.map(fichaTreino, FichaTreinoDTO.class);
    }
}

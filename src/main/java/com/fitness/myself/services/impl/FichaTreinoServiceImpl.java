package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.FichaTreinoDTO;
import com.fitness.myself.domain.treino.Exercicio;
import com.fitness.myself.domain.treino.FichaTreino;
import com.fitness.myself.repositories.IFichaTreinoRepository;
import com.fitness.myself.services.AlunoService;
import com.fitness.myself.services.ExercicioService;
import com.fitness.myself.services.FichaTreinoService;
import com.fitness.myself.services.PersonalService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaTreinoServiceImpl extends GenericServiceImpl<IFichaTreinoRepository> implements FichaTreinoService {

    @Autowired
    private PersonalService personalService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ExercicioService exercicioService;


    @Override
    public FichaTreino insertFichaTreino(FichaTreino entity, Long personalId, Long alunoId) {
        entity.atribuirPersonal(personalService.findById(personalId));
        entity.atribuirFichaAluno(alunoService.findById(alunoId));

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
    public void adicionarExerciciosALista(Long idFicha, List<Long> ids) {
        FichaTreino fichaTreino = findById(idFicha);
        for (Long e : ids) {
            fichaTreino.adicionarExercicio(exercicioService.findById(e));
        }
        getRepository().save(fichaTreino);
    }

    @Override
    public FichaTreinoDTO toFichaTreinoDTO(FichaTreino fichaTreino) {
        return modelMapper.map(fichaTreino, FichaTreinoDTO.class);
    }


}

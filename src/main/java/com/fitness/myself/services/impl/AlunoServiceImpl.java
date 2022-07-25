package com.fitness.myself.services.impl;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.repositories.IAlunoRepository;
import com.fitness.myself.services.IAlunoService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl extends GenericServiceImpl<IAlunoRepository> implements IAlunoService {

    @Override
    public Aluno insert(Aluno entity) {
        return getRepository().save(entity);
    }

    @Override
    public Aluno findById(Long id) {
        Optional<Aluno> aluno = getRepository().findById(id);
        return aluno.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = findById(id);
        getRepository().delete(aluno);
    }
}

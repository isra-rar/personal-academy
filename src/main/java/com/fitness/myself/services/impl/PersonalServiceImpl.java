package com.fitness.myself.services.impl;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.repositories.IPersonalRepository;
import com.fitness.myself.services.IAlunoService;
import com.fitness.myself.services.IPersonalService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalServiceImpl extends GenericServiceImpl<IPersonalRepository> implements IPersonalService {

    @Autowired
    private IAlunoService alunoService;

    @Override
    public Personal insert(Personal entity) {
        return getRepository().save(entity);
    }

    @Override
    public Personal findById(Long id) {
        Optional<Personal> personal = getRepository().findById(id);
        return personal.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Personal personal = findById(id);
        getRepository().delete(personal) ;
    }

    @Override
    public void atribuirAluno(Long personalId, Long alunoId) {
        Personal personal = findById(personalId);
        Aluno aluno = alunoService.findById(alunoId);

        personal.addAluno(aluno);

        getRepository().save(personal);
    }
}

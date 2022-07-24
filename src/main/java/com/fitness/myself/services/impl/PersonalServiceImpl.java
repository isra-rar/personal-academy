package com.fitness.myself.services.impl;

import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.repositories.IPersonalRepository;
import com.fitness.myself.services.IPersonalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalServiceImpl extends GenericServiceImpl<IPersonalRepository> implements IPersonalService {


    @Override
    public Personal insert(Personal entity) {
        return getRepository().save(entity);
    }

    @Override
    public Personal findById(Long id) {
        Optional<Personal> personal = getRepository().findById(id);
        return personal.orElseThrow(); //TODO criar uma exception personalizada
    }

    @Override
    public void delete(Long id) {
        Personal personal = findById(id);
        getRepository().delete(personal);
    }
}

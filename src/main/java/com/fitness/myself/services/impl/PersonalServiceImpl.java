package com.fitness.myself.services.impl;

import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.repositories.IPersonalRepository;
import com.fitness.myself.services.IPersonalService;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl extends GenericServiceImpl<IPersonalRepository> implements IPersonalService {


    @Override
    public Personal insert(Personal entity) {
        return getRepository().save(entity);
    }
}

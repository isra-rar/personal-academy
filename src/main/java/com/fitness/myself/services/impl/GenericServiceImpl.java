package com.fitness.myself.services.impl;

import com.fitness.myself.repositories.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericServiceImpl<T extends IRepository> {

    @Autowired
    private T repository;

    public T getRepository(){
        return repository;
    }
}

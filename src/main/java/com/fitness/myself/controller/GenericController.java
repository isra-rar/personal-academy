package com.fitness.myself.controller;

import com.fitness.myself.services.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericController<T extends IGenericService> {

    @Autowired
    private T service;

    public T getService() {
        return service;
    }

}

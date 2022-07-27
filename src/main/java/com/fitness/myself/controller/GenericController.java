package com.fitness.myself.controller;

import com.fitness.myself.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericController<T extends GenericService> {

    @Autowired
    private T service;

    public T getService() {
        return service;
    }

}

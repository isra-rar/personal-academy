package com.fitness.myself.resource;

import com.fitness.myself.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class GenericController<T extends GenericService> {

    private final T service;

    public T getService() {
        return service;
    }

}

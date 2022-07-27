package com.fitness.myself.services.impl;

import com.fitness.myself.repositories.IRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<T extends IRepository> {

    @Autowired
    private T repository;

    @Autowired
    protected ModelMapper modelMapper;

    public T getRepository(){
        return repository;
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}

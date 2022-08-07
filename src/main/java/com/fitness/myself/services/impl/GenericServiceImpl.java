package com.fitness.myself.services.impl;

import com.fitness.myself.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<T extends GenericRepository> {

    private final T repository;

    protected final ModelMapper modelMapper;

    public T getRepository(){
        return repository;
    }

    protected <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}

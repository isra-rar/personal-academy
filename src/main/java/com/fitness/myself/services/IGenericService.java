package com.fitness.myself.services;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.repositories.IRepository;

public interface IGenericService<T extends BaseEntity> {
    T insert(T entity);
    T findById(Long id);
    void delete(Long id);
}

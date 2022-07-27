package com.fitness.myself.services;

import com.fitness.myself.domain.baseAbstract.BaseEntity;

public interface GenericService<T extends BaseEntity> {
    T insert(T entity);
    T findById(Long id);
    void delete(Long id);
}

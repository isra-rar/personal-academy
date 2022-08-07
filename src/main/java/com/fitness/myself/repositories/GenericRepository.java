package com.fitness.myself.repositories;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}

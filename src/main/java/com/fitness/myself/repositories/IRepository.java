package com.fitness.myself.repositories;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}

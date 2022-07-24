package com.fitness.myself.repositories;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.aluno.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExercicioRepository extends IRepository<Exercicio> {
}

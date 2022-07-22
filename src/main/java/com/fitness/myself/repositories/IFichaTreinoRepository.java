package com.fitness.myself.repositories;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.aluno.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
}

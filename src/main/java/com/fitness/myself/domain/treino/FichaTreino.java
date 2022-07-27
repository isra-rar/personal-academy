package com.fitness.myself.domain.treino;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.enums.TipoFicha;
import com.fitness.myself.domain.personal.Personal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class FichaTreino extends BaseEntity {

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private TipoFicha tipoFicha;

    @OneToMany
    private List<Exercicio> exercicios = new ArrayList<>();

    @ManyToMany(mappedBy = "fichaTreinos", fetch = FetchType.LAZY)
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Personal personal;

}

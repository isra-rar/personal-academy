package com.fitness.myself.domain.treino;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.enums.GrupoMuscular;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Exercicio extends BaseEntity {

    private String descricao;
    private int series;
    private int repeticoes;

    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;

    @ManyToMany(mappedBy = "exercicios")
    private List<FichaTreino> fichaTreinos = new ArrayList<>();

}

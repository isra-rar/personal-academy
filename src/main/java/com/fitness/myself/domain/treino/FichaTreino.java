package com.fitness.myself.domain.treino;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private LocalDate dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private TipoFicha tipoFicha;

    @ManyToMany
    @JoinTable(name = "fichaTreino_exercicio",
            joinColumns =
            @JoinColumn(name = "fichaTreino_id"),
            inverseJoinColumns =
            @JoinColumn(name = "exercicio_id"))
    private List<Exercicio> exercicios = new ArrayList<>();

    @ManyToOne
    private Aluno aluno;

    @ManyToOne(cascade = CascadeType.ALL)
    private Personal personal;

    public void atribuirPersonal(Personal personal) {
        this.personal = personal;
    }

    public void atribuirFichaAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }
}

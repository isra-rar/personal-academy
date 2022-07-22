package com.fitness.myself.domain.aluno;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FichaPessoal extends BaseEntity {

    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private int peso;
    private Double altura;
    private String objetivo;

    @OneToMany(mappedBy = "fichaPessoal")
    private List<Aluno> alunos = new ArrayList<>();

}

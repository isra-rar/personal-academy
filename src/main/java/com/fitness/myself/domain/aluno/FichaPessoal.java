package com.fitness.myself.domain.aluno;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class FichaPessoal extends BaseEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private int peso;
    private Double altura;
    private String objetivo;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaPessoal")
    private List<Aluno> alunos = new ArrayList<>();

    public FichaPessoal(Date dataNascimento, Sexo sexo, int peso, Double altura, String objetivo) {
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
    }
}

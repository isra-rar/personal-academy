package com.fitness.myself.domain.aluno;

import com.fitness.myself.domain.baseAbstract.Usuario;
import com.fitness.myself.domain.enums.TipoPlano;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.domain.valuesObjects.CPF;
import com.fitness.myself.domain.valuesObjects.Email;
import com.fitness.myself.domain.valuesObjects.Telefone;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Aluno extends Usuario {

    private String nomeAcademia;
    @Enumerated(EnumType.STRING)
    private TipoPlano tipoPlano;

    @ManyToOne
    private FichaPessoal fichaPessoal;

    @ManyToMany
    @JoinTable(
            name = "aluno_fichaTreino",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "fichaTreino_id"))
    private List<FichaTreino> fichaTreinos = new ArrayList<>();

    @ManyToOne
    private Personal personal;

    @Builder
    public Aluno(String nome, CPF cpf, Email email, Telefone telefone, String password, String nomeAcademia, TipoPlano tipoPlano, FichaPessoal fichaPessoal, Personal personal) {
        super(nome, cpf, email, telefone, password);
        this.nomeAcademia = nomeAcademia;
        this.tipoPlano = tipoPlano;
        this.fichaPessoal = fichaPessoal;
        this.personal = personal;
    }

}

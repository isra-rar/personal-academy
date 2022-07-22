package com.fitness.myself.domain.personal;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.baseAbstract.Usuario;
import com.fitness.myself.domain.valuesObjects.CPF;
import com.fitness.myself.domain.valuesObjects.Email;
import com.fitness.myself.domain.valuesObjects.Telefone;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Entity
public class Personal extends Usuario {

    @ManyToOne
    private CREF cref;

    @OneToMany(mappedBy = "personal")
    private List<Aluno> alunos = new ArrayList<>();

    public Personal(String nome, CPF cpf, Email email, Telefone telefone, String password, CREF cref) {
        super(nome, cpf, email, telefone, password);
        this.cref = cref;
    }
}

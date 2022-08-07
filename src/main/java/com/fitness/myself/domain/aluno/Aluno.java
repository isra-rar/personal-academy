package com.fitness.myself.domain.aluno;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.usuario.Usuario;
import com.fitness.myself.domain.enums.TipoPlano;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.domain.treino.FichaTreino;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Aluno extends BaseEntity {

    private String nomeAcademia;
    @Enumerated(EnumType.STRING)
    private TipoPlano tipoPlano;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    private FichaPessoal fichaPessoal;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<FichaTreino> fichaTreinos = new ArrayList<>();

    @ManyToOne
    private Personal personal;

    @Builder
    public Aluno(String nomeAcademia, TipoPlano tipoPlano, FichaPessoal fichaPessoal) {
        this.nomeAcademia = nomeAcademia;
        this.tipoPlano = tipoPlano;
        this.fichaPessoal = fichaPessoal;
    }

    public void atribuirPersonal(Personal personal) {
        this.personal = personal;
    }

    public void atribuirUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

package com.fitness.myself.domain.personal;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.usuario.Usuario;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Getter
@Entity
public class Personal extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    private CREF cref;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "personal")
    private List<Aluno> alunos = new ArrayList<>();

    @Builder
    public Personal(CREF cref) {
        this.cref = cref;
    }

    public void atribuirUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

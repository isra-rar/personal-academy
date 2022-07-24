package com.fitness.myself.domain.personal;

import com.fitness.myself.domain.baseAbstract.BaseEntity;
import com.fitness.myself.domain.enums.UF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class CREF extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UF uf;

    private String codigo;

    @OneToMany(mappedBy = "cref")
    private List<Personal> personais = new ArrayList<>();

    public CREF(UF uf, String codigo) {
        this.uf = uf;
        this.codigo = codigo;
    }
}

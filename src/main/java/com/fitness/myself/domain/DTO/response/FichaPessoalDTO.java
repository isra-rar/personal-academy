package com.fitness.myself.domain.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fitness.myself.domain.enums.Sexo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
public class FichaPessoalDTO {


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private int peso;
    private Double altura;
    private String objetivo;
}

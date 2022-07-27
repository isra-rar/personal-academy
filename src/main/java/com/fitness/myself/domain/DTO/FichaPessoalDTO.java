package com.fitness.myself.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fitness.myself.domain.enums.Sexo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FichaPessoalDTO {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date dataNascimento;
    private String  sexo;
    private int peso;
    private Double altura;
    private String objetivo;
}

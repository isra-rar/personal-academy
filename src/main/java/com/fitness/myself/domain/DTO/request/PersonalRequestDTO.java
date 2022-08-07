package com.fitness.myself.domain.DTO.request;

import com.fitness.myself.domain.DTO.response.CREFDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalRequestDTO {

    private Long usuarioId;
    private CREFDTO cref;
}

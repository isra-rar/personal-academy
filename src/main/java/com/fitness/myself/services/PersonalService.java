package com.fitness.myself.services;


import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.DTO.PersonalDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;

import java.util.List;

public interface PersonalService extends GenericService<Personal> {

    PersonalDTO toPersonalDTO(Personal personal);
    Personal toPersonal(PersonalDTO personalDTO);
    List<PersonalDTO> findAllPersonais();
}

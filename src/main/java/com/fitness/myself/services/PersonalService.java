package com.fitness.myself.services;


import com.fitness.myself.domain.DTO.request.PersonalRequestDTO;
import com.fitness.myself.domain.DTO.response.PersonalDTO;
import com.fitness.myself.domain.personal.Personal;

import java.util.List;

public interface PersonalService extends GenericService<Personal> {

    PersonalDTO insert(PersonalRequestDTO entity);
    PersonalDTO toPersonalDTO(Personal personal);
    Personal toPersonal(PersonalDTO personalDTO);
    List<PersonalDTO> findAllPersonais();
}

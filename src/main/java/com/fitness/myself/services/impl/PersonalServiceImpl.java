package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.DTO.PersonalDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.repositories.IPersonalRepository;
import com.fitness.myself.services.PersonalService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalServiceImpl extends GenericServiceImpl<IPersonalRepository> implements PersonalService {

    @Override
    public Personal insert(Personal entity) {
        return getRepository().save(entity);
    }

    @Override
    public Personal findById(Long id) {
        Optional<Personal> personal = getRepository().findById(id);
        return personal.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Personal personal = findById(id);
        getRepository().delete(personal) ;
    }
    @Override
    public List<PersonalDTO> findAllPersonais() {
        List<Personal> personalList = getRepository().findAll();
        return toPersonalListDTO(personalList);
    }

    private List<PersonalDTO> toPersonalListDTO(List<Personal> personalList) {
        return mapList(personalList, PersonalDTO.class);
    }

    @Override
    public PersonalDTO toPersonalDTO(Personal personal) {
        return modelMapper.map(personal, PersonalDTO.class);
    }

    @Override
    public Personal toPersonal(PersonalDTO personalDTO) {
        return modelMapper.map(personalDTO, Personal.class);
    }

}

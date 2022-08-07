package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.request.PersonalRequestDTO;
import com.fitness.myself.domain.DTO.response.PersonalDTO;
import com.fitness.myself.domain.personal.CREF;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.domain.usuario.Usuario;
import com.fitness.myself.repositories.PersonalRepository;
import com.fitness.myself.services.PersonalService;
import com.fitness.myself.services.UsuarioService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl extends GenericServiceImpl<PersonalRepository> implements PersonalService {

    private final UsuarioService usuarioService;
    public PersonalServiceImpl(PersonalRepository repository, ModelMapper modelMapper, UsuarioService usuarioService) {
        super(repository, modelMapper);
        this.usuarioService = usuarioService;
    }

    @Override
    public PersonalDTO insert(PersonalRequestDTO entity) {
        Usuario usuario = usuarioService.findById(entity.getUsuarioId());
        Personal personal = toPersonal(entity);
        personal.atribuirUsuario(usuario);
        getRepository().save(personal);
        return toPersonalDTO(personal);
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
    private Personal toPersonal(PersonalRequestDTO personalDTO) {
        return new Personal(new CREF(personalDTO.getCref().getUf(), personalDTO.getCref().getCodigo()));
    }

}

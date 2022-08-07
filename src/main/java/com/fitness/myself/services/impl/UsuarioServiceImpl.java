package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.request.UsuarioRequestDTO;
import com.fitness.myself.domain.DTO.response.UsuarioDTO;
import com.fitness.myself.domain.usuario.Usuario;
import com.fitness.myself.repositories.UsuarioRepository;
import com.fitness.myself.services.UsuarioService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioRepository> implements UsuarioService {


    public UsuarioServiceImpl(UsuarioRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> usuario = getRepository().findById(id);
        return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<UsuarioDTO> findAllUsuarios() {
        List<Usuario> personalList = getRepository().findAll();
        return toPersonalListDTO(personalList);
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = findById(id);
        getRepository().delete(usuario);
    }

    @Override
    public Usuario insert(UsuarioRequestDTO entity) {
        Usuario usuario = toUsuario(entity);
        return getRepository().save(usuario);
    }

    @Override
    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    private Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return new Usuario(usuarioRequestDTO.getNome(),
                usuarioRequestDTO.getCpf(),
                usuarioRequestDTO.getEmail(),
                usuarioRequestDTO.getTelefone(),
                usuarioRequestDTO.getPassword());
    }

    private List<UsuarioDTO> toPersonalListDTO(List<Usuario> usuarioList) {
        return mapList(usuarioList, UsuarioDTO.class);
    }


}

package com.fitness.myself.services;

import com.fitness.myself.domain.DTO.request.UsuarioRequestDTO;
import com.fitness.myself.domain.DTO.response.UsuarioDTO;
import com.fitness.myself.domain.usuario.Usuario;

import java.util.List;

public interface UsuarioService extends GenericService<Usuario> {

    Usuario insert(UsuarioRequestDTO entity);
    UsuarioDTO toUsuarioDTO(Usuario usuario);
    List<UsuarioDTO> findAllUsuarios();
}

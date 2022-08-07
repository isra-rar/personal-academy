package com.fitness.myself.repositories;

import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.domain.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario> {

    Usuario findUsuarioByEmail(String email);
    boolean existsByEmail(String email);

}

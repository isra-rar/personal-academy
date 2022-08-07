package com.fitness.myself.resource;

import com.fitness.myself.domain.DTO.request.UsuarioRequestDTO;
import com.fitness.myself.domain.DTO.response.UsuarioDTO;
import com.fitness.myself.domain.usuario.Usuario;
import com.fitness.myself.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/usuario")
public class UsuarioController extends GenericController<UsuarioService> {

    public UsuarioController(UsuarioService service) {
        super(service);
    }

    @PostMapping()
    public ResponseEntity<UsuarioDTO> insertPersonal(@RequestBody UsuarioRequestDTO obj) {
        Usuario usuario = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(getService().toUsuarioDTO(usuario));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findPersonalById(@PathVariable Long id) {
        Usuario usuario = getService().findById(id);
        return ResponseEntity.ok(getService().toUsuarioDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        return ResponseEntity.ok(getService().findAllUsuarios());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUsuarioById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

}

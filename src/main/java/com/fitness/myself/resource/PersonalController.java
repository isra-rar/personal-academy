package com.fitness.myself.resource;

import com.fitness.myself.domain.DTO.request.PersonalRequestDTO;
import com.fitness.myself.domain.DTO.response.PersonalDTO;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.services.PersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/personal")
public class PersonalController extends GenericController<PersonalService>{

    public PersonalController(PersonalService service) {
        super(service);
    }

    @PostMapping()
    public ResponseEntity<PersonalDTO> insertPersonal(@RequestBody PersonalRequestDTO obj) {
        PersonalDTO personal = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personal.getId()).toUri();
        return ResponseEntity.created(uri).body(personal);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonalDTO> findPersonalById(@PathVariable Long id) {
        Personal personal = getService().findById(id);
        return ResponseEntity.ok(getService().toPersonalDTO(personal));
    }

    @GetMapping
    public ResponseEntity<List<PersonalDTO>> getAllPersonais() {
        return ResponseEntity.ok(getService().findAllPersonais());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePersonalById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

}

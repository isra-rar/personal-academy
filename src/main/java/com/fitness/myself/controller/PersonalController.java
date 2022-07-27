package com.fitness.myself.controller;

import com.fitness.myself.domain.DTO.PersonalDTO;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.services.PersonalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/personal")
public class PersonalController extends GenericController<PersonalService>{

    @PostMapping()
    public ResponseEntity<PersonalDTO> insertPersonal(@RequestBody Personal obj) {
        Personal personal = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personal.getId()).toUri();
        return ResponseEntity.created(uri).body(getService().toPersonalDTO(personal));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonalDTO> findPersonalById(@PathVariable Long id) {
        Personal personal = getService().findById(id);
        return ResponseEntity.ok(getService().toPersonalDTO(personal));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePersonalById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

}

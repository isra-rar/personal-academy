package com.fitness.myself.controller;

import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.services.IPersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/personal")
public class PersonalController extends GenericController<IPersonalService>{

    @PostMapping()
    public ResponseEntity<Personal> insert(@RequestBody Personal obj) {
        Personal personal = getService().insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personal.getId()).toUri();
        return ResponseEntity.created(uri).body(personal);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Personal> findPersonalById(@PathVariable Long id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePersonalById(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}

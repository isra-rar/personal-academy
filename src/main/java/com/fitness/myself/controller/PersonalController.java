package com.fitness.myself.controller;

import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.services.IPersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}

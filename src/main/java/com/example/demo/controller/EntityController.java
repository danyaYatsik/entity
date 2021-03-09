package com.example.demo.controller;

import com.example.demo.model.Entity;
import com.example.demo.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
class EntityController {

    private final EntityService entityService;

    @Autowired
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping(path = "/entity/{entityId}")
    public Entity getOne(@PathVariable long entityId) {
        return entityService.getById(entityId);
    }

    @GetMapping(path = "/entity")
    public Iterable<Entity> getAll() {
        return entityService.getAll();
    }

    @PostMapping(path = "/entity")
    public ResponseEntity<Entity> save(@RequestBody Entity requestEntity) {
        Entity entity = entityService.save(requestEntity);
        if (requestEntity.getId() == 0) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/entity/{entityId}")
    public void deleteOne(@PathVariable long entityId) {
        entityService.deleteById(entityId);
    }

}
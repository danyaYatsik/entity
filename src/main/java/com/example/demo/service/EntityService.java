package com.example.demo.service;

import com.example.demo.model.Entity;

public interface EntityService {

    Iterable<Entity> getAll();

    Entity getById(long id);

    void deleteById(long id);

    Entity save(Entity entity);
}

package com.example.demo.repository;

import com.example.demo.model.Entity;

import java.util.Optional;

public interface EntityRepository {

    Iterable<Entity> getAll();

    Optional<Entity> getById(long id);

    void deleteById(long id);

    Entity save(Entity entity);
}

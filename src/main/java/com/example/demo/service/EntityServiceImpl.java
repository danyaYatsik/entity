package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Entity;
import com.example.demo.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;

    @Autowired
    public EntityServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Iterable<Entity> getAll() {
        return entityRepository.getAll();
    }

    @Override
    public Entity getById(long id) {
        return entityRepository
                .getById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(long id) {
        entityRepository
                .getById(id)
                .orElseThrow(EntityNotFoundException::new);

        entityRepository.deleteById(id);
    }

    @Override
    public Entity save(Entity entity) {
        if (!(entity.getId() == 0)) {
            entityRepository
                    .getById(entity.getId())
                    .orElseThrow(EntityNotFoundException::new);
        }
        return entityRepository.save(entity);
    }
}

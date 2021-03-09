package com.example.demo.repository;

import com.example.demo.model.Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MockEntityRepository implements EntityRepository {

    private final Map<Long, Entity> mockStorage = new HashMap<>(4) {{
        put(1L, new Entity(1L, "name 1"));
        put(2L, new Entity(2L, "name 2"));
        put(3L, new Entity(3L, "name 3"));
        put(4L, new Entity(4L, "name 4"));
    }};

    @Override
    public Iterable<Entity> getAll() {
        return mockStorage.values();
    }

    @Override
    public Optional<Entity> getById(long id) {
        return Optional.ofNullable(mockStorage.get(id));
    }

    @Override
    public void deleteById(long id) {
        mockStorage.remove(id);
    }

    @Override
    public Entity save(Entity entity) {
        Entity entityToCreate = new Entity();
        BeanUtils.copyProperties(entity, entityToCreate);

        if (entityToCreate.getId() == 0) {
            entityToCreate.setId(mockStorage.size() + 1);
        }

        mockStorage.put(entityToCreate.getId(), entityToCreate);
        return mockStorage.get(entityToCreate.getId());
    }
}

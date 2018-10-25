package com.epam.geometry.repository;

import com.epam.geometry.entity.Tetrahedron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TetrahedronRepository<T> implements Repository<Tetrahedron> {
    private Map<Long, Tetrahedron> data = new HashMap<>();

    @Override
    public void add(Tetrahedron object) {
        data.put(object.getId(), object);
    }

    @Override
    public List<Tetrahedron> findBy(Specification specification) {
        return data.values().stream().
                filter(o -> specification.specified(o)).collect(Collectors.toList());

    }
}

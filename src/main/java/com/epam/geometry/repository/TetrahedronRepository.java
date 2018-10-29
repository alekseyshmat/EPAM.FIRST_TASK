package com.epam.geometry.repository;

import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class TetrahedronRepository implements Repository<Tetrahedron> {

    private Map<Long, Tetrahedron> data = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger();

    public Map<Long, Tetrahedron> getTetrahedrons() {
        return data;
    }

    @Override
    public void add(Tetrahedron object) {
        data.put(object.getId(), object);
        LOGGER.info("Adding in repository is done");
    }

    @Override
    public void remove(Tetrahedron object) {
        data.remove(object.getId(), object);
        LOGGER.info("Removing from repository is done");
    }

    @Override
    public void update(Tetrahedron object) {
        for (Map.Entry<Long, Tetrahedron> record : data.entrySet()) {
            if (record.getKey().equals(object.getId())) {
                data.put(object.getId(), object);
                LOGGER.info("Updating in repository is done");
            }
        }
    }

    @Override
    public List<Tetrahedron> findBy(Specification specification) {
        return data.values().stream().
                filter(o -> specification.specified(o)).
                collect(Collectors.toList());
    }

    @Override
    public List<Tetrahedron> sortBy(Comparator comparator) {
        return data.values().stream().
                sorted((t1, t2) -> comparator.compare(t1, t2)).
                collect(Collectors.toList());
    }

    @Override
    public List<Tetrahedron> deleteBy(Specification specification) {
        return data.values().stream().filter(o -> specification.specified(o)).collect(Collectors.toList());
    }


}

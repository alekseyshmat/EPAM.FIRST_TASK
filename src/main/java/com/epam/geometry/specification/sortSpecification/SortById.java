package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortById implements Comparator<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        LOGGER.debug("Sort by id is done!");
        return (int) (o1.getId() - o2.getId());
    }
}

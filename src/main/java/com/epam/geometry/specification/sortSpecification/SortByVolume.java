package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortByVolume implements Comparator<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        LOGGER.debug("Sort by volume is done!");

        return 0; //TODO
    }
}

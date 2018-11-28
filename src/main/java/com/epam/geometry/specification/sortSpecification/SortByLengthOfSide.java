package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortByLengthOfSide implements Comparator<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        double sideOfFirstTetrahedron = o1.getSideAB();
        double sideOfSecondTetrahedron = o2.getSideAB();

        if (sideOfFirstTetrahedron < sideOfSecondTetrahedron) {
            LOGGER.debug("Sort by length of side is done:side of first tetrahedron shorter then side of second tetrahedron");
            return LESS;
        } else if (sideOfFirstTetrahedron == sideOfSecondTetrahedron) {
            LOGGER.debug("Sort by length of side is done: side of first tetrahedron = side of second tetrahedron");
            return EQUALS;
        } else {
            LOGGER.debug("Sort by length of side is done: side of first tetrahedron longer then side of second tetrahedron");
            return LARGER;
        }
    }
}

package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortByVolume implements Comparator<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;
    private Calculator calculator = new Calculator();

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        double volumeOfFirstTetrahedron = calculator.calculateVolume(o1);
        double volumeOfSecondTetrahedron = calculator.calculateVolume(o2);

        if (volumeOfFirstTetrahedron < volumeOfSecondTetrahedron) {
            LOGGER.debug("Sort by volume is done: volume of first tetrahedron < then volume of second tetrahedron");
            return LESS;
        } else if (volumeOfFirstTetrahedron == volumeOfSecondTetrahedron) {
            LOGGER.debug("Sort by volume is done: volume of first tetrahedron = volume of second tetrahedron");
            return EQUALS;
        } else {
            LOGGER.debug("Sort by volume is done: volume of first tetrahedron > then volume of second tetrahedron");
            return LARGER;
        }
    }
}

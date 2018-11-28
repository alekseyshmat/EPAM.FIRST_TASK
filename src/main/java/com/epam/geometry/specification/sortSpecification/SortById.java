package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortById implements Comparator<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        long first_id = o1.getId();
        long second_id = o2.getId();

        if (first_id < second_id) {
            LOGGER.debug("Sort by id is done: first id < second id");
            return LESS;
        } else if (first_id == second_id) {
            LOGGER.debug("Sort by id is done: first id = second id");
            return EQUALS;
        } else {
            LOGGER.debug("Sort by id is done: first id > second id");
            return LARGER;
        }
    }
}

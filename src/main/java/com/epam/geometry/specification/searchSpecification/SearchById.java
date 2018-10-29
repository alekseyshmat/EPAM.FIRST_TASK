package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SearchById implements Specification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private long id;

    public SearchById(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Tetrahedron object) {
        if (id == object.getId()) {
            LOGGER.info("Search by id is done!");
            return true;
        } else {
            LOGGER.info("Search by id is not done!");
            return false;
        }
    }
}

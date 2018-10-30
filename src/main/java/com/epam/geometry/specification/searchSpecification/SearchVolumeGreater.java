package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchVolumeGreater implements Specification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private double volume;
    private Calculator calculator = new Calculator();

    public SearchVolumeGreater(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Tetrahedron object) {
        double currentVolume = calculator.calculateVolume(object);
        if (currentVolume > volume) {
            LOGGER.debug("Search by greater volume is done!");
            return true;
        } else {
            LOGGER.debug("Search by greater volume is not done!");
            return false;
        }
    }
}

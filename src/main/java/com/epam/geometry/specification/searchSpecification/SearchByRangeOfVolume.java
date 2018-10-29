package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchByRangeOfVolume implements Specification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private double minVolume;
    private double maxVolume;
    private Calculator calculator = new Calculator();


    public SearchByRangeOfVolume(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Tetrahedron object) {
        double area = calculator.calculateVolume(object);
        if (area >= minVolume && area <= maxVolume) {
            LOGGER.debug("Search by range of volume is done!");
            return true;
        } else {
            return false;
        }
    }
}

package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchByRangeOfArea implements Specification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();
    private double minArea;
    private double maxArea;
    private Calculator calculator = new Calculator();


    public SearchByRangeOfArea(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Tetrahedron object) {
        double area = calculator.calculateArea(object);
        if (area >= minArea && area <= maxArea) {
            LOGGER.debug("Search by range of area is done!");
            return true;
        } else {
            return false;
        }
    }
}

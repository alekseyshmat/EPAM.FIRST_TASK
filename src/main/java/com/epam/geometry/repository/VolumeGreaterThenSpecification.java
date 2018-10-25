/*
package com.epam.geometry.repository;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Tetrahedron;

public class VolumeGreaterThenSpecification implements Specification<Tetrahedron> {
    private double volume;
    private Calculator calculator = new Calculator();

    public VolumeGreaterThenSpecification(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Tetrahedron object) {
        double currentVolume = calculator.calculateVolume(Tetrahedron);
        return Double.compare(currentVolume, volume) > volume;
    }
}
*/

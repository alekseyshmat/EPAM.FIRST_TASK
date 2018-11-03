package com.epam.geometry.registrar;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.observer.Observer;
import com.epam.geometry.observer.TetrahedronEvent;

public class TetrahedronsRegistrar implements Observer {

    private Calculator calculator = new Calculator();

    private long id;
    private double area;
    private double volume;
    private double volumeRatio;

    public TetrahedronsRegistrar() {
    }

    public long getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public double getVolumeRatio() {
        return volumeRatio;
    }

    @Override
    public void handleEvent(TetrahedronEvent event) {
        Tetrahedron tetrahedron = event.getTetrahedron();
        id = tetrahedron.getId();
        area = calculator.calculateArea(tetrahedron);
        volume = calculator.calculateVolume(tetrahedron);
        volumeRatio = calculator.calculateVolumeRatio(tetrahedron);
    }
}

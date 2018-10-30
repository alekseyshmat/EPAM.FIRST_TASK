package com.epam.geometry.registrator;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.action.TetrahedronActions;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.observer.Observer;
import com.epam.geometry.observer.TetrahedronEvent;

public class TetrahedronsRegistrator implements Observer {

    private Calculator calculator = new Calculator();

    private long id;
    private double area;
    private double volume;

    public TetrahedronsRegistrator() {
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

    @Override
    public void handleEvent(TetrahedronEvent event) {
        Tetrahedron tetrahedron = event.getTetrahedron();
        Tetrahedron t = TetrahedronActions.changePointsValues(tetrahedron);
        id = tetrahedron.getId();
        area = calculator.calculateArea(t);
        volume = calculator.calculateVolume(t);

        //todo add logger
    }
}

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

    public TetrahedronsRegistrator(long id, double area, double volume) {
        this.id = id;
        this.area = area;
        this.volume = volume;
    }

    public TetrahedronsRegistrator() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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

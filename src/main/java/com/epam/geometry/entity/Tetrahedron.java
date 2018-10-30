package com.epam.geometry.entity;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.generator.Generator;
import com.epam.geometry.observer.Observable;
import com.epam.geometry.observer.Observer;
import com.epam.geometry.observer.TetrahedronEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Tetrahedron implements Observable<Observer> {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<Observer> observers = new ArrayList<>();

    private Point pointA, pointB, pointC, pointD;
    private long id;
    private double sideAB, sideAC, sideBC;

    private Calculator calculator = new Calculator();

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.id = Generator.generate();
        notifyObservers();
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public long getId() {
        return id;
    }

    public double getSideAB() {
        sideAB = calculator.calculateSide(pointA, pointB);
        return sideAB;
    }

    public double getSideAC() {
        sideAC = calculator.calculateSide(pointA, pointC);
        return sideAC;
    }

    public double getSideBC() {
        sideBC = calculator.calculateSide(pointB, pointC);
        return sideBC;
    }

    public void setSideAB(double sideAB) {
        this.sideAB = sideAB;
        notifyObservers();
        LOGGER.info("Side AB was changed");
    }

    public void setSideAC(double sideAC) {
        this.sideAC = sideAC;
        notifyObservers();
        LOGGER.info("Side AC was changed");
    }

    public void setSideBC(double sideBC) {
        this.sideBC = sideBC;
        notifyObservers();
        LOGGER.info("Side BC was changed");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Tetrahedron tetrahedron = (Tetrahedron) obj;
        return tetrahedron.getPointA() == this.getPointA() &&
                tetrahedron.getPointB() == this.getPointB() &&
                tetrahedron.getPointC() == this.getPointC() &&
                tetrahedron.getPointD() == this.getPointD();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getPointA().getX() + this.getPointA().getY() + this.getPointA().getZ());
        result = prime * result + (int) (this.getPointB().getX() + this.getPointB().getY() + this.getPointB().getZ());
        result = prime * result + (int) (this.getPointC().getX() + this.getPointC().getY() + this.getPointC().getZ());
        result = prime * result + (int) (this.getPointD().getX() + this.getPointD().getY() + this.getPointD().getZ());
        return result;
    }

    @Override
    public String toString() {
        return "Tetrahedron {pointA=" + pointA + ", pointB=" + pointB +
                ", pointC=" + pointC + ", pointD=" + pointD + '}';
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.handleEvent(new TetrahedronEvent(this));
        LOGGER.info("Adding observer is done");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        LOGGER.info("Removing observer is done");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(new TetrahedronEvent(this));
        }
    }
}

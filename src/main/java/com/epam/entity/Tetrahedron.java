package com.epam.entity;

import com.epam.action.Calculator;
import com.epam.action.TetrahedronActions;

import java.util.List;

public class Tetrahedron {

    private Point pointA, pointB, pointC, pointD;
    private double edge, edgeOfSection;
    private Calculator calculator;

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        calculator = new Calculator();
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

    public double getSideAB() {
        return calculator.calculateSide(pointA, pointB);
    }

    public double getSideAC() {
        return calculator.calculateSide(pointA, pointC);
    }

    public double getSideBC() {
        return calculator.calculateSide(pointB, pointC);
    }

    public double getSideDA() {
        return calculator.calculateSide(pointD, pointA);
    }

    public double getSideDB() {
        return calculator.calculateSide(pointD, pointB);
    }

    public double getSideDC() {
        return calculator.calculateSide(pointD, pointC);
    }
}

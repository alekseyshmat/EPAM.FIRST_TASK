package com.epam.entity;

import com.epam.action.Calculator;
import com.epam.action.TetrahedronActions;

import java.util.List;

public class Tetrahedron {

    private Point pointA, pointB, pointC, pointD;
    private TetrahedronActions tetrahedronActions;
    private double edge, edgeOfSection;

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
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
        return tetrahedronActions.createSide(pointA, pointB);
    }

    public double getSideAC() {
        return tetrahedronActions.createSide(pointA, pointC);
    }

    public double getSideBC() {
        return tetrahedronActions.createSide(pointB, pointC);
    }

    public double getSideDA() {
        return tetrahedronActions.createSide(pointD, pointA);
    }

    public double getSideDB() {
        return tetrahedronActions.createSide(pointD, pointB);
    }

    public double getSideDC() {
        return tetrahedronActions.createSide(pointD, pointC);
    }
}

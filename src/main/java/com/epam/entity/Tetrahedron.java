package com.epam.entity;

import com.epam.action.Calculator;

public class Tetrahedron {

    private Point pointA, pointB, pointC, pointD;
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
        return "Tetrahedron{pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", pointD=" + pointD + '}';
    }
}

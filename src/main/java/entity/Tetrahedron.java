package entity;

import action.Calculator;

public class Tetrahedron {

    private Point pointA, pointB;


    public Tetrahedron(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public double getEdge() {
        return new Calculator().calculateEdge(this);
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }
}

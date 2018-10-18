package entity;

import action.Calculator;

public class Tetrahedron {

    private Point pointA, pointB, pointC, pointD;
    private double edge, edgeOfSection;

    public Tetrahedron(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public double getEdge() {
        return new Calculator().calculateEdge(this);
    }

    public void setEdgeOfSection(double edgeOfSection) {
        this.edgeOfSection = edgeOfSection;
    }

   /* public double getEdgeOfSection() {
        return edgeOfSection;
    }*/

    public double getEdgeOfSection() {
        return new Calculator().calculateEdgeOfSection(this);
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

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

}

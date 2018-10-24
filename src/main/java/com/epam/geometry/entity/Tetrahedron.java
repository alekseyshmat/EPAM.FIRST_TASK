package com.epam.geometry.entity;

public class Tetrahedron {

    private Point pointA, pointB, pointC, pointD;
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Tetrahedron{pointA=" + pointA + ", pointB=" + pointB +
                ", pointC=" + pointC + ", pointD=" + pointD + '}';
    }
}

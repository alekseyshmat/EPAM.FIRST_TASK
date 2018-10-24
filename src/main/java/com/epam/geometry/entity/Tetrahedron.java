package com.epam.geometry.entity;

public class Tetrahedron {

    private TetrahedronPoint tetrahedronPointA, tetrahedronPointB, tetrahedronPointC, tetrahedronPointD;

    public Tetrahedron(TetrahedronPoint tetrahedronPointA, TetrahedronPoint tetrahedronPointB, TetrahedronPoint tetrahedronPointC, TetrahedronPoint tetrahedronPointD) {
        this.tetrahedronPointA = tetrahedronPointA;
        this.tetrahedronPointB = tetrahedronPointB;
        this.tetrahedronPointC = tetrahedronPointC;
        this.tetrahedronPointD = tetrahedronPointD;
    }

    public TetrahedronPoint getTetrahedronPointA() {
        return tetrahedronPointA;
    }

    public TetrahedronPoint getTetrahedronPointB() {
        return tetrahedronPointB;
    }

    public TetrahedronPoint getTetrahedronPointC() {
        return tetrahedronPointC;
    }

    public TetrahedronPoint getTetrahedronPointD() {
        return tetrahedronPointD;
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
        return tetrahedron.getTetrahedronPointA() == this.getTetrahedronPointA() &&
                tetrahedron.getTetrahedronPointB() == this.getTetrahedronPointB() &&
                tetrahedron.getTetrahedronPointC() == this.getTetrahedronPointC() &&
                tetrahedron.getTetrahedronPointD() == this.getTetrahedronPointD();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getTetrahedronPointA().getX() + this.getTetrahedronPointA().getY() + this.getTetrahedronPointA().getZ());
        result = prime * result + (int) (this.getTetrahedronPointB().getX() + this.getTetrahedronPointB().getY() + this.getTetrahedronPointB().getZ());
        result = prime * result + (int) (this.getTetrahedronPointC().getX() + this.getTetrahedronPointC().getY() + this.getTetrahedronPointC().getZ());
        result = prime * result + (int) (this.getTetrahedronPointD().getX() + this.getTetrahedronPointD().getY() + this.getTetrahedronPointD().getZ());
        return result;
    }

    @Override
    public String toString() {
        return "Tetrahedron{tetrahedronPointA=" + tetrahedronPointA + ", tetrahedronPointB=" + tetrahedronPointB +
                ", tetrahedronPointC=" + tetrahedronPointC + ", tetrahedronPointD=" + tetrahedronPointD + '}';
    }
}

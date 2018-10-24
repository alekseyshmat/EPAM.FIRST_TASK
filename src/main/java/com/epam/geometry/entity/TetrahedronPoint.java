package com.epam.geometry.entity;

public class TetrahedronPoint {

    private double x;
    private double y;
    private double z;

    public TetrahedronPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        TetrahedronPoint tetrahedronPoint = (TetrahedronPoint) obj;
        return tetrahedronPoint.getX() == this.getX() &&
                tetrahedronPoint.getY() == this.getY() &&
                tetrahedronPoint.getZ() == this.getZ();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) this.getX();
        result = prime * result + (int) this.getY();
        result = prime * result + (int) this.getZ();
        return result;
    }

    @Override
    public String toString() {
        return "TetrahedronPoint{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

}

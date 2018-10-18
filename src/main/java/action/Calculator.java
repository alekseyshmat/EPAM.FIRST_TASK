package action;

import entity.Point;
import entity.Tetrahedron;

public class Calculator {

    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_TWELVE = 12;

    public double calculateArea(Tetrahedron tetrahedron) {
        double edge = tetrahedron.getEdge();
        return Math.pow(edge, NUMBER_TWO) * Math.sqrt(NUMBER_THREE);
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double edge = tetrahedron.getEdge();
        return (Math.sqrt(NUMBER_THREE) / NUMBER_TWELVE) * Math.pow(edge, NUMBER_THREE);
    }

    public double calculateEdge(Tetrahedron tetrahedron) {

        return Math.sqrt(Math.pow((tetrahedron.getPointA().getX() - tetrahedron.getPointB().getX()), NUMBER_TWO) +
                Math.pow((tetrahedron.getPointA().getY() - tetrahedron.getPointB().getY()), NUMBER_TWO) +
                Math.pow((tetrahedron.getPointA().getZ() - tetrahedron.getPointB().getZ()), NUMBER_TWO));
    }

}

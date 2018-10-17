public class Calculator {

    public double calculateArea(Tetrahedron tetrahedron) {
        double edge = tetrahedron.getEdge();
        double square = Math.pow(edge, 2) * Math.sqrt(3);
        return square;
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double edge = tetrahedron.getEdge();
        double volume = (Math.sqrt(3) / 12) * Math.pow(edge, 3);
        return volume;
    }

}

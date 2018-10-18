import action.Calculator;
import entity.Point;
import entity.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private final Tetrahedron TETRAHEDRON = new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1));
    private final Calculator CALCULATOR = new Calculator();

    private final double DELTA = 0.01;

    @Test
    public void shouldReturnTrueSquare() {
        double square = CALCULATOR.calculateArea(TETRAHEDRON);
        Assert.assertEquals(square, 13.86, DELTA);
    }

    @Test
    public void shouldReturnTrueVolume() {
        double volume = CALCULATOR.calculateVolume(TETRAHEDRON);
        Assert.assertEquals(volume, 3.26, DELTA);
    }

    @Test
    public void shouldReturnTrueEdge() {
        double length = CALCULATOR.calculateEdge(TETRAHEDRON);
        Assert.assertEquals(length, 2.83, DELTA);
    }

    @Test
    public void shouldReturnTrueHeight() {
        double height = CALCULATOR.calculateHeight(TETRAHEDRON);
        Assert.assertEquals(height, 2.3, DELTA);
    }

    @Test
    public void shouldReturnTrueEdgeOfSection() {
        double length = CALCULATOR.calculateEdgeOfSection(TETRAHEDRON);
        Assert.assertEquals(length, 1.41, DELTA);
    }

    @Test
    public void shouldReturnTrueHeightOfSmallTetrahedron() {
        double height = CALCULATOR.calculateHeightOfSmallTetrahedron(TETRAHEDRON);
        Assert.assertEquals(height, 1.15, DELTA);
    }
}

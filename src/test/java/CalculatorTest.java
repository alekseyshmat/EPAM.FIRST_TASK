import action.Calculator;
import entity.Point;
import entity.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private final Tetrahedron TETRAHEDRON = new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0));
    private final Calculator CALCULATOR = new Calculator();

    private final double DELTA = 0.01;

    @Test
    public void shouldReturnTrueSquare() {
        double square = CALCULATOR.calculateArea(TETRAHEDRON);

        Assert.assertEquals(square, 13.86, DELTA);
    }

    @Test
    public void shouldReturnTrueVolume() {
        Calculator calculator = new Calculator();

        double volume = calculator.calculateVolume(TETRAHEDRON);

        Assert.assertEquals(volume, 3.26, DELTA);
    }

    @Test
    public void shouldReturnTrueEdge() {

        double length = CALCULATOR.calculateEdge(TETRAHEDRON);

        Assert.assertEquals(length, 2.83, DELTA);
    }
}

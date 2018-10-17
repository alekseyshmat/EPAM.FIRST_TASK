import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private final Tetrahedron TETRAHEDRON = new Tetrahedron(1);
    private final double DELTA = 0.01;

    @Test
    public void shouldReturnTrueSquare() {
        Calculator calculator = new Calculator();

        double square = calculator.calculateArea(TETRAHEDRON);

        Assert.assertEquals(1.73, square, DELTA);
    }

    @Test
    public void shouldReturnTrueVolume() {
        Calculator calculator = new Calculator();

        double volume = calculator.calculateVolume(TETRAHEDRON);

        Assert.assertEquals(0.14, volume, DELTA);
    }
}

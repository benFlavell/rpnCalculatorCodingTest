import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class ExampleTests {
    @Test
    public void example1Test() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("5 2");

        assertEquals("5 2", calculateStackTester.calculate());
    }

    @Test
    public void example2Test() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("2 sqrt");

        assertEquals("1.4142135623", calculateStackTester.calculate());
    }

    @Test
    public void example3Test() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("5 2 - 3 - clear");

        assertEquals("", calculateStackTester.calculate());
    }

    @Test
    public void example4Test() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("5 4 3 2 undo undo * 5 * undo");

        assertEquals("20 5", calculateStackTester.calculate());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void example5Test() throws IOException {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("operator * (position: 15): insufficient parameters stack: 11");

        CalculateStack calculateStackTester = new CalculateStack("1 2 3 * 5 + * * 6 5");

        calculateStackTester.calculate();
    }

}

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class OperatorTests {
    @Test
    public void AdditionTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 +");

        assertEquals("14", calculateStackTester.calculate());
    }

    @Test
    public void SubtractionTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 -");

        assertEquals("6", calculateStackTester.calculate());
    }

    @Test
    public void MultiplicationTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 *");

        assertEquals("40", calculateStackTester.calculate());
    }

    @Test
    public void DivisionTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 /");

        assertEquals("2.5", calculateStackTester.calculate());
    }

    @Test
    public void sqrtTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("9 sqrt");

        assertEquals("3", calculateStackTester.calculate());
    }

    @Test
    public void undoTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 + undo");

        assertEquals("10 4", calculateStackTester.calculate());
    }

    @Test
    public void ClearTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 clear");

        assertEquals("", calculateStackTester.calculate());
    }
}

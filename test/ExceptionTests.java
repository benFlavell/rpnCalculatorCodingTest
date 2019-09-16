import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class ExceptionTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void InsufficientParametersExceptionTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 /");

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("operator / (position: 4): insufficient parameters stack: 10");

        calculateStackTester.calculate();
    }

    @Test
    public void InvalidCommandExceptionTest() throws IOException {
        CalculateStack calculateStackTester = new CalculateStack("10 4 multiply");

        exceptionRule.expect(IOException.class);
        exceptionRule.expectMessage("invalid command in input at position 6");

        calculateStackTester.calculate();
    }
}

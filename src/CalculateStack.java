import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EmptyStackException;
import java.util.Stack;

public class CalculateStack {
    private Stack<Double> stack;
    private Stack<Stack<Double>> history;
    private String[] input;
    private Integer position;

    public CalculateStack(String input) {
        this.input = input.split(" ");

        this.stack = new Stack<>();
        this.history = new Stack<>();
        this.history.push(new Stack<>());
        this.position = 1;
    }

    public String calculate() throws IOException, IllegalArgumentException {
        for (String command : this.input) {

            try {
                switch (command) {
                    case "undo":
                        history.pop();
                        stack = history.pop();
                        break;
                    case "clear":
                        stack = new Stack<>();
                        break;
                    case "sqrt":
                        stack.push(Math.sqrt(stack.pop()));
                        break;
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        Double number2 = stack.pop();
                        Double number1 = stack.pop();
                        stack.push(number1 - number2);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        Double denominator = stack.pop();
                        Double numerator = stack.pop();
                        stack.push(numerator / denominator);
                        break;
                    default:
                        if (command.matches("[0-9]*")) {
                            this.stack.push(Double.parseDouble(command));
                        } else {
                            throw new IOException("invalid command in input at position " + position);
                        }
                        break;
                }
            } catch (EmptyStackException exception) {
                stack = history.pop();
                throw new IllegalArgumentException("operator " + command + " (position: " + position + "): insufficient parameters stack: " + parseStackState());
            }

            position += command.length() + 1;

            history.push((Stack<Double>) stack.clone());
        }
        return parseStackState();
    }

    private String parseStackState() {

        DecimalFormat decimalFormat = new DecimalFormat("0.##########");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            String formattedNumber = decimalFormat.format(stack.pop());
            result.insert(0, formattedNumber + " ");
        }

        return result.toString().trim();
    }
}

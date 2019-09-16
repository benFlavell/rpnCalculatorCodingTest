public class RpnCalculator {
    public static void main(String[] args) {
        String input = "";

        if (args.length > 0) {
            for (String arg: args) {
                input += arg + " ";
            }
        } else {
            input = "1 2 3 * 5 + *";
        }

        try {
            String result = new CalculateStack(input).calculate();
            System.out.println(result);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}

/**
 * SimpleInterestCalculator
 *
 * A small CLI utility to compute simple interest.
 *
 * Usage:
 *   java SimpleInterestCalculator <principal> <annualRatePercent> <timeYears>
 *
 * Example:
 *   java SimpleInterestCalculator 1000 5 2
 *
 * Output:
 *   Principal: 1000.00
 *   Rate (%): 5.00
 *   Time (years): 2.00
 *   Simple Interest: 100.00
 *   Total Amount: 1100.00
 */
public class SimpleInterestCalculator {

    public static void main(String[] args) {
        if (args.length != 3) {
            printUsage("Expected 3 arguments: <principal> <annualRatePercent> <timeYears>.");
            System.exit(1);
        }

        double principal;
        double annualRatePercent;
        double timeYears;

        try {
            principal = Double.parseDouble(args[0]);
            annualRatePercent = Double.parseDouble(args[1]);
            timeYears = Double.parseDouble(args[2]);
        } catch (NumberFormatException nfe) {
            printUsage("All arguments must be numeric.");
            System.exit(1);
            return;
        }

        if (principal < 0 || annualRatePercent < 0 || timeYears < 0) {
            printUsage("All arguments must be non-negative.");
            System.exit(1);
        }

        double rate = annualRatePercent / 100.0;
        double interest = principal * rate * timeYears;
        double total = principal + interest;

        System.out.printf("Principal: %.2f%n", principal);
        System.out.printf("Rate (%%): %.2f%n", annualRatePercent);
        System.out.printf("Time (years): %.2f%n", timeYears);
        System.out.printf("Simple Interest: %.2f%n", interest);
        System.out.printf("Total Amount: %.2f%n", total);
    }

    private static void printUsage(String error) {
        System.err.println("Error: " + error);
        System.err.println();
        System.err.println("Usage:");
        System.err.println("  java SimpleInterestCalculator <principal> <annualRatePercent> <timeYears>");
        System.err.println();
        System.err.println("Example:");
        System.err.println("  java SimpleInterestCalculator 1000 5 2");
    }
}

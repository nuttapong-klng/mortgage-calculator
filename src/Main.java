import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal (1K - 1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float annualInterest;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        int period;
        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();
            if (period >= 1 && period <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }

        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        int PayingMonths = period * MONTH_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, PayingMonths))
                / (Math.pow(1 + monthlyInterest, PayingMonths) - 1);

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
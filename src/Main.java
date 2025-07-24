import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();

        System.out.print("Period (Years): ");
        int period = scanner.nextInt();

        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        int PayingMonths = period * MONTH_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, PayingMonths))
                / (Math.pow(1 + monthlyInterest, PayingMonths) - 1);

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
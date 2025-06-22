import java.util.Scanner;
import java.io.*;

public class Financial {
    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double futureValueIterative(double presentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            presentValue *= (1 + growthRate);
        }
        return presentValue;
    }

    public static void main(String[] args) {
        double presentValue = 5000;  
        double rate = 0.06;          
        int years = 10;

        double resultRecursive = futureValue(presentValue, rate, years);
        System.out.printf("Recursive: Predicted future value after %d years: ₹%.2f%n", years, resultRecursive);

        double resultIterative = futureValueIterative(presentValue, rate, years);
        System.out.printf("Iterative: Predicted future value after %d years: ₹%.2f%n", years, resultIterative);
    }
}

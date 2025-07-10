import  java.util.*;

import java.util.Scanner;

public class Main {

    public static double forecastValue(double presentValue, double rate, int years) {
        if (years == 0)
            return presentValue;
        return forecastValue(presentValue * (1 + rate), rate, years - 1);
    }

    public static double fastForecast(double presentValue, double rate, int years) {
        return presentValue * Math.pow(1 + rate, years);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pv, rate;
        int years;
        System.out.println("\nFinancial Forecasting Menu");
        System.out.println("1. Forecast using Recursion");
        System.out.println("2. Forecast using Optimized Math.pow");
        System.out.println("0. Exit");
        while (true) {

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter Present Value (e.g., 10000): ₹");
            pv = sc.nextDouble();

            System.out.print("Enter Annual Growth Rate (e.g., 5 for 5%): ");
            rate = sc.nextDouble() / 100;  

            System.out.print("Enter Number of Years: ");
            years = sc.nextInt();

            if (choice == 1) {
                double result = forecastValue(pv, rate, years);
                System.out.printf("Recursive Forecast after %d years: ₹%.2f\n", years, result);
            } else if (choice == 2) {
                double result = fastForecast(pv, rate, years);
                System.out.printf("Optimized Forecast after %d years: ₹%.2f\n", years, result);
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}


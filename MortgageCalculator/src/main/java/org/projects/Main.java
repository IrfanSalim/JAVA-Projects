package org.projects;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * This is the main class for the mortgage calculator.
 */
public class Main {

    /**
     * The main method that prompts the user for input and calls the calculateMortgage method.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Welcome to your mortgage calculator!");
        System.out.print("Enter the loan amount: ");
        long principal = sc.nextLong();
        System.out.print("Enter the annual interest rate: ");
        double interest = sc.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = sc.nextInt();

        // Calculate the mortgage amount
        double mortgage = calculateMortgage(principal, interest, years);

        // Format the mortgage amount as currency
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        // Display the mortgage amount
        System.out.println("Your mortgage will be: " + formattedMortgage);
    }

    /**
     * Calculates the mortgage amount based on the principal, interest rate, and number of years.
     *
     * @param principal The loan amount.
     * @param interest The annual interest rate.
     * @param years The number of years.
     * @return The mortgage amount.
     */
    private static double calculateMortgage(long principal, double interest, int years) {
        int months = years * 12;
        double monthlyInterest = (interest / 100) / 12;
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, months)) / (Math.pow(1 + monthlyInterest, months) - 1);
    }
}
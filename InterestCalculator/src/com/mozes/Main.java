package com.mozes;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Define constants
        final byte PERCENT = 100;
        final float MIN_YEARS = 0;
        final float MAX_YEARS = 30;
        final byte MONTHS_IN_A_YEAR = 12;
        final int LOWER_PRINCIPAL = 1_000;
        final int UPPER_PRINCIPAL = 1_000_000;
        final float MIN_ANNUAL_INTEREST_RATE = 0;
        final float MAX_ANNUAL_INTEREST_RATE = 30;

        // Create the scanner object and declare variables
        int years;
        int principal;
        int monthsInYear;
        double monthlyPayments;
        float annualInterestRate;
        float monthlyInterestRate;
        Scanner scanner = new Scanner(System.in);

        // Handle user inputs
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal < LOWER_PRINCIPAL || principal > UPPER_PRINCIPAL) {
                System.out.println("Enter an amount between $1,000 and $1,000,000");
            }
            else
                break;
        }

        // Ask user for annual interest rate and handle error
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate < MIN_ANNUAL_INTEREST_RATE || annualInterestRate > MAX_ANNUAL_INTEREST_RATE) {
                System.out.println("Enter an interest rate between 0 and 30");
            }
            else
                break;
        }
        // Calculate the monthly interest rate.
        monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_A_YEAR;

        // Ask user for the number of years
        while (true) {
            System.out.print("Enter the number of years: ");
            years = scanner.nextInt();
            if (years < MIN_YEARS || years > MAX_YEARS)
                System.out.println("Enter year(s) between 0 and 30");
            else
                break;
        }
        // Calculate the months in a year
        monthsInYear = years * MONTHS_IN_A_YEAR;

        // Calculate the interest
        monthlyPayments = principal * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), monthsInYear))
                                    / (Math.pow((1 + monthlyInterestRate), monthsInYear) - 1));
        System.out.println("Loan is:" + NumberFormat.getCurrencyInstance().format(monthlyPayments));
    }
}

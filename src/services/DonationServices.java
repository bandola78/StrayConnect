package services;

import models.Donation;

import java.time.LocalDate;
import java.util.Scanner;

public class DonationServices {

    public void collectDonation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter donation type (Money/Food): ");
        String donationType = scanner.nextLine();
        double amount = 0;

        if (donationType.equalsIgnoreCase("Money")) {
            System.out.print("Enter amount to donate: ");
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount entered.");
                return;
            }
        }

        Donation donation = new Donation(donorName, amount, donationType, LocalDate.now());
        recordDonation(donation);

        System.out.println("Thank you for your donation! Details:");
        donation.displayDonationInfo();
    }

    private void recordDonation(Donation donation) {
        System.out.println("Donation recorded successfully.");
    }
}

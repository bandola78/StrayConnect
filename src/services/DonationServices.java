package services;

import models.Donation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonationServices {

    private List<Donation> donations = new ArrayList<>();

    public void handleDonation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String donorName = scanner.nextLine().trim();
        donorName = utils.DataValidator.formatName(donorName);
        if (donorName == null) {
            System.out.println("Invalid name. Returning to main menu.");
            return;
        }

        System.out.println("Donation Type: 1. Money  2. Food");
        int type;
        try {
            type = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Returning to main menu.");
            return;
        }

        if (type == 1) {
            System.out.print("Enter amount to donate: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Returning to main menu.");
                return;
            }
            donations.add(new Donation(donorName, amount, "Money", LocalDate.now()));
            System.out.println("Thank you for your monetary donation!");
        } else if (type == 2) {
            System.out.print("Enter food donation in kilograms: ");
            int kilograms;
            try {
                kilograms = Integer.parseInt(scanner.nextLine().trim());
                if (kilograms <= 0) {
                    System.out.println("Invalid amount. Returning to main menu.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Returning to main menu.");
                return;
            }
            if (kilograms <= 20) {
                System.out.println("Thank you! The shelter can pick up your donation.");
            } else {
                System.out.println("Please deliver the food donation to our center at:");
                System.out.println("Stray Connect Animal Rescue Center");
                System.out.println("Sitio Maharlika, Barangay San Isidro");
                System.out.println("Lipa City, Batangas 4217, Philippines");
            }
        } else {
            System.out.println("Invalid option. Returning to main menu.");
        }
    }

    public List<Donation> getDonations() {
        return donations;
    }
}

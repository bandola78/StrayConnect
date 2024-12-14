package services;

import models.Donation;
import utils.InputHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonationServices {

    private List<Donation> donations = new ArrayList<>();

    public void handleDonation(Scanner scanner) {
        InputHelper.clearConsole(); 
        System.out.println("\n=== Donate ===");

        System.out.println("1. Donate Money");
        System.out.println("2. Donate Food");
        System.out.print("Choose donation type: ");

        try {
            int donationType = Integer.parseInt(scanner.nextLine());

            switch (donationType) {
                case 1:
                    System.out.print("Enter amount to donate: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    donations.add(new Donation("Anonymous", amount, "Money", LocalDate.now()));
                    System.out.println("Thank you for your monetary donation!");
                    break;

                case 2:
                    System.out.print("Enter amount of food in kilograms: ");
                    int foodWeight = Integer.parseInt(scanner.nextLine());
                    if (foodWeight > 20) {
                        System.out.println("Please deliver your donation to our center. Address will be provided.");
                    } else {
                        System.out.println("Thank you! The shelter can pick up your donation.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Returning to main menu.");
                    InputHelper.pause(2);
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }

        InputHelper.pause(3); // Pause after completion
        InputHelper.clearConsole(); // Clear console before returning to menu
    }

    public List<Donation> getDonations() {
        return donations;
    }
}

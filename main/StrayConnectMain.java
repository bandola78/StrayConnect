package main;

import models.*;
import models.AnimalAttributes.*;
import services.*;
import reports.*;
import utils.*;
import models.StrayAnimal;
import services.AnimalServices;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class StrayConnectMain {

    private static AnimalServices animalServices = new AnimalServices();
    private static VolunteerServices volunteerServices = new VolunteerServices();
    private static DonationServices donationServices = new DonationServices();
    private static FosterServices fosterServices = new FosterServices();
    private static ReportsGenerator reportGenerator = new ReportsGenerator();
    private static PetRegistrationServices petServices = new PetRegistrationServices();


    private static List<AdoptionRecord> adoptionRecords = new ArrayList<>();
    private static List<Donation> donations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== WELCOME TO STRAY CONNECT! ===");
            System.out.println("1. Adopt");
            System.out.println("2. Surrender Stray");
            System.out.println("3. Foster");
            System.out.println("4. Donate");
            System.out.println("5. Register a Pet");
            System.out.println("6. Want to Be a Volunteer?");
            System.out.println("7. Generate Reports");
            System.out.println("8. View Stray Connect Address");
            System.out.println("9.Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                        case 1:
                            handleAdoption(scanner);
                            break;
                        case 2:
                            animalServices.intakeAnimal(scanner);
                            break;
                        case 3:
                            handleFoster(scanner);
                            break;
                        case 4:
                            handleDonation(scanner);
                            break;
                        case 5:
                            petServices.registerPet(scanner);
                            break;
                        case 6:
                            volunteerServices.registerVolunteer(scanner);
                            break;
                        case 7:
                            handleReports(scanner);
                            break;
                        case 8:
                            displayCenterDetails();
                            break;
                        case 9:
                            System.out.println("Thank you for using Stray Connect. Goodbye!");
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void handleAdoption(Scanner scanner) {
        System.out.println("\n=== Adoption ===");

        if (animalServices.getStrayAnimals().isEmpty()) {
            System.out.println("No animals available for adoption.");
            return;
        }
        
        System.out.println("Available Animals for Adoption:");
        var strayAnimals = animalServices.getStrayAnimals();
        for (int i = 0; i < strayAnimals.size(); i++) {
            System.out.println((i + 1) + ". " + strayAnimals.get(i).getName() + " (" + strayAnimals.get(i).getSpecies() + ")");
        }

        try {
            System.out.print("Enter the number of the animal to adopt: ");
            int animalIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (animalIndex < 0 || animalIndex >= strayAnimals.size()) {
                System.out.println("Invalid selection.");
                return;
            }

            StrayAnimal selectedAnimal = strayAnimals.get(animalIndex);

            System.out.print("Enter adopter's name: ");
            String adopterName = scanner.nextLine();

            AdoptionRecord adoptionRecord = new AdoptionRecord(adopterName, selectedAnimal, java.time.LocalDate.now());
            adoptionRecords.add(adoptionRecord);
            animalServices.getStrayAnimals().remove(selectedAnimal);

            System.out.println("Adoption completed! Details:");
            adoptionRecord.displayAdoptionInfo();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static void handleFoster(Scanner scanner) {
        System.out.println("\n=== Foster ===");

        if (animalServices.getStrayAnimals().isEmpty()) {
            System.out.println("No animals available for fostering.");
            return;
        }

        System.out.println("Available Animals for Fostering:");
        var strayAnimals = animalServices.getStrayAnimals();
        for (int i = 0; i < strayAnimals.size(); i++) {
            System.out.println((i + 1) + ". " + strayAnimals.get(i).getName() + " (" + strayAnimals.get(i).getSpecies() + ")");
        }

        try {
            System.out.print("Enter the number of the animal to foster: ");
            int animalIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (animalIndex < 0 || animalIndex >= strayAnimals.size()) {
                System.out.println("Invalid selection.");
                return;
            }

            StrayAnimal selectedAnimal = strayAnimals.get(animalIndex);
            fosterServices.initiateFoster(scanner, selectedAnimal);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static void handleDonation(Scanner scanner) {
        System.out.println("\n=== Donate ===");
        donationServices.handleDonation(scanner);
    }

    private static void handleReports(Scanner scanner) {
        System.out.println("\n=== Generate Reports ===");
        System.out.println("1. Adoption Report");
        System.out.println("2. Donation Report");
        System.out.println("3. Volunteer Report");
        System.out.print("Select report to generate: ");

        try {
            int reportChoice = Integer.parseInt(scanner.nextLine());

            switch (reportChoice) {
                case 1: 
                    reportGenerator.generateAdoptionReport(adoptionRecords);
                    break;
                case 2: 
                    reportGenerator.generateDonationReport(donations);
                    break;
                case 3: 
                    reportGenerator.generateVolunteerReport(volunteerServices.getVolunteers());
                    break;
                default:
                    System.out.println("Invalid report choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public static void displayCenterDetails() {
        System.out.println("=== Stray Connect Animal Rescue Center ===");
        System.out.println("Address:");
        System.out.println("Sitio Maharlika, Barangay San Isidro");
        System.out.println("Lipa City, Batangas 4217, Philippines");
        System.out.println("We are committed to rescuing and rehoming animals in need.");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            System.out.println("An error occurred while waiting. Returning to the main menu immediately.");
        }
    }    
}

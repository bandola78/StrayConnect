import models.*;
import models.AnimalAttributes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrayConnectMain {

    private static List<Volunteer> volunteers = new ArrayList<>();
    private static List<StrayAnimal> strayAnimals = new ArrayList<>();
    private static List<RegisteredPet> registeredPets = new ArrayList<>();
    private static List<AdoptionRecord> adoptionRecords = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        while (true) {
            System.out.println("\n=== Stray Connect ===");
            System.out.println("1. Adoption");
            System.out.println("2. Intake (Stray Animal)");
            System.out.println("3. Pet Registration");
            System.out.println("4. Volunteer Registration");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> handleAdoption(scanner);
                case 2 -> handleIntake(scanner);
                case 3 -> handlePetRegistration(scanner);
                case 4 -> handleVolunteerRegistration(scanner);
                case 5 -> {
                    System.out.println("Thank you for using Stray Connect. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleAdoption(Scanner scanner) {
        System.out.println("\n=== Adoption ===");

        if (strayAnimals.isEmpty()) {
            System.out.println("No animals available for adoption.");
            return;
        }

        // List all stray animals for adoption
        System.out.println("Available Animals for Adoption:");
        for (int i = 0; i < strayAnimals.size(); i++) {
            System.out.println((i + 1) + ". " + strayAnimals.get(i).getName() + " (" + strayAnimals.get(i).getSpecies() + ")");
        }

        System.out.print("Enter the number of the animal to adopt: ");
        int animalIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (animalIndex < 0 || animalIndex >= strayAnimals.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        StrayAnimal selectedAnimal = strayAnimals.get(animalIndex);

        System.out.print("Enter adopter's name: ");
        String adopterName = scanner.nextLine();

        // Create an adoption record and remove the animal from strayAnimals
        AdoptionRecord adoptionRecord = new AdoptionRecord(adopterName, selectedAnimal, LocalDate.now());
        adoptionRecords.add(adoptionRecord);
        strayAnimals.remove(selectedAnimal);

        System.out.println("Adoption completed! Details:");
        adoptionRecord.displayAdoptionInfo();
    }

    private static void handleIntake(Scanner scanner) {
        System.out.println("\n=== Intake (Stray Animal) ===");

        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal gender (M/F): ");
        Gender gender = scanner.nextLine().equalsIgnoreCase("M") ? Gender.M : Gender.F;
        System.out.print("Enter animal species (CAT/DOG): ");
        Species species = scanner.nextLine().equalsIgnoreCase("CAT") ? Species.CAT : Species.DOG;
        System.out.print("Enter animal color: ");
        String color = scanner.nextLine();
        System.out.print("Enter animal age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Is the animal vaccinated? (true/false): ");
        boolean vaccinated = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter health status: ");
        String healthStatus = scanner.nextLine();
        System.out.print("Enter animal size (SMALL, MEDIUM, LARGE): ");
        Size size = Size.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter rescue location: ");
        String locationFound = scanner.nextLine();
        System.out.print("Enter rescuer name: ");
        String rescuerName = scanner.nextLine();
        System.out.print("Enter rescuer contact: ");
        String rescuerContact = scanner.nextLine();

        StrayAnimal strayAnimal = new StrayAnimal(name, gender, species, color, age, vaccinated, healthStatus, size, locationFound, LocalDate.now(), rescuerName, rescuerContact);
        strayAnimals.add(strayAnimal);

        System.out.println("Stray animal intake completed!");
        strayAnimal.displayInfo();
    }

    private static void handlePetRegistration(Scanner scanner) {
        System.out.println("\n=== Pet Registration ===");

        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet gender (M/F): ");
        Gender gender = scanner.nextLine().equalsIgnoreCase("M") ? Gender.M : Gender.F;
        System.out.print("Enter pet species (CAT/DOG): ");
        Species species = scanner.nextLine().equalsIgnoreCase("CAT") ? Species.CAT : Species.DOG;
        System.out.print("Enter pet color: ");
        String color = scanner.nextLine();
        System.out.print("Enter pet age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Is the pet vaccinated? (true/false): ");
        boolean vaccinated = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter health status: ");
        String healthStatus = scanner.nextLine();
        System.out.print("Enter pet size (SMALL, MEDIUM, LARGE): ");
        Size size = Size.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();

        RegisteredPet registeredPet = new RegisteredPet(name, gender, species, color, age, vaccinated, healthStatus, size, ownerName);
        registeredPets.add(registeredPet);

        System.out.println("Pet registration completed!");
        registeredPet.displayInfo();
    }

    private static void handleVolunteerRegistration(Scanner scanner) {
        System.out.println("\n=== Volunteer Registration ===");

        System.out.print("Enter volunteer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter volunteer contact info: ");
        String contactInfo = scanner.nextLine();

        Volunteer volunteer = new Volunteer(name, contactInfo);
        volunteers.add(volunteer);

        System.out.println("Volunteer registration completed!");
        volunteer.displayVolunteerInfo();
    }
}


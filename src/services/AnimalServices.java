package services;

import models.StrayAnimal;
import models.AnimalAttributes.DogColor;
import models.AnimalAttributes.CatColor;
import models.AnimalAttributes.Gender;
import models.AnimalAttributes.Size;
import models.AnimalAttributes.Species;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalServices {

    private List<StrayAnimal> strayAnimals;

    public AnimalServices() {
        this.strayAnimals = new ArrayList<>();
    }

    public void intakeAnimal(Scanner scanner) {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine().trim();
        name = utils.DataValidator.formatName(name);
        if (name == null) {
            System.out.println("Invalid name. Returning to main menu.");
            return;
        }

        System.out.print("Enter animal species (DOG/CAT): ");
        String speciesInput = scanner.nextLine().trim().toUpperCase();

        Species speciesEnum;
        try {
            speciesEnum = Species.valueOf(speciesInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid species. Returning to main menu.");
            return;
        }

        System.out.print("Enter animal gender (M/F): ");
        String genderInput = scanner.nextLine().trim();
        String gender = utils.DataValidator.mapGender(genderInput);
        if (gender == null) {
            System.out.println("Invalid gender. Returning to main menu.");
            return;
        }

        System.out.print("Enter animal color: ");
        String colorInput = scanner.nextLine().trim().toUpperCase();

        Enum<?> colorEnum;
        try {
            if (speciesEnum == Species.DOG) {
                colorEnum = DogColor.valueOf(colorInput);
            } else if (speciesEnum == Species.CAT) {
                colorEnum = CatColor.valueOf(colorInput);
            } else {
                System.out.println("Unsupported species. Returning to main menu.");
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color for " + speciesEnum + ". Returning to main menu.");
            return;
        }

        System.out.print("Enter animal age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
            if (!utils.DataValidator.validateNumberRange(age, 0, 30)) {
                System.out.println("Invalid age. Returning to main menu.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Returning to main menu.");
            return;
        }

        System.out.print("Is the animal vaccinated? (Yes/No): ");
        String vaccinatedInput = scanner.nextLine().trim();
        if (!utils.DataValidator.validateYesNo(vaccinatedInput)) {
            System.out.println("Invalid vaccination status. Returning to main menu.");
            return;
        }
        boolean isVaccinated = "YES".equalsIgnoreCase(vaccinatedInput);

        System.out.print("Enter health status (Healthy or specify condition): ");
        String healthStatus = scanner.nextLine().trim();
        if (!healthStatus.equalsIgnoreCase("Healthy")) {
            healthStatus = "Condition: " + healthStatus;
        }

        System.out.print("Enter rescue location (Landmark, Barangay, City): ");
        String location = scanner.nextLine().trim();
        if (!location.contains(",") || location.split(",").length < 3) {
            System.out.println("Invalid location. Returning to main menu.");
            return;
        }

        System.out.print("Enter rescuer contact (+63XXXXXXXXXX or 'None'): ");
        String rescuerContact = scanner.nextLine().trim();
        if (!utils.DataValidator.validateContactNumber(rescuerContact)) {
            System.out.println("Invalid contact. Returning to main menu.");
            return;
        }

        StrayAnimal strayAnimal = new StrayAnimal(
                name,
                Gender.valueOf(gender),
                speciesEnum,
                colorEnum,
                age,
                Size.MEDIUM,
                isVaccinated,
                healthStatus,
                location,
                LocalDate.now(),
                "Rescuer",
                rescuerContact
        );

        strayAnimals.add(strayAnimal);
        System.out.println("Animal intake completed!");
    }

    public List<StrayAnimal> getStrayAnimals() {
        return strayAnimals;
    }
}

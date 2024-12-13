package services;

import models.RegisteredPet;
import models.AnimalAttributes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetRegistrationServices {

    private List<RegisteredPet> registeredPets = new ArrayList<>();

    public void registerPet(Scanner scanner) {
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine().trim();
        name = utils.DataValidator.formatName(name);
        if (name == null) {
            System.out.println("Invalid name. Returning to main menu.");
            return;
        }

        System.out.print("Enter pet gender (M/F): ");
        String genderInput = scanner.nextLine().trim();
        String gender = utils.DataValidator.mapGender(genderInput);
        if (gender == null) {
            System.out.println("Invalid gender. Returning to main menu.");
            return;
        }

        System.out.print("Enter pet species (CAT/DOG): ");
        String speciesInput = scanner.nextLine().trim();
        Species species;
        try {
            species = Species.valueOf(speciesInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid species. Returning to main menu.");
            return;
        }

        System.out.print("Enter pet color (BLACK/WHITE/BROWN/GREY/ORANGE/OTHER): ");
        GeneralColor color;
        try {
            color = GeneralColor.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color. Returning to main menu.");
            return;
        }

        System.out.print("Enter pet age: ");
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

        System.out.print("Is the pet vaccinated? (Yes/No): ");
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

        System.out.print("Enter owner's name: ");
        String ownerName = scanner.nextLine().trim();
        ownerName = utils.DataValidator.formatName(ownerName);
        if (ownerName == null) {
            System.out.println("Invalid owner name. Returning to main menu.");
            return;
        }

        RegisteredPet pet = new RegisteredPet(name, Gender.valueOf(gender), species, color, age,
                Size.MEDIUM, isVaccinated, healthStatus, ownerName);
        registeredPets.add(pet);

        System.out.println("Pet registration completed!");
    }

    public List<RegisteredPet> getRegisteredPets() {
        return registeredPets;
    }
}

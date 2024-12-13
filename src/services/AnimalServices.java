package services;

import models.StrayAnimal;
import static models.AnimalAttributes.Species;
import static models.AnimalAttributes.Gender;
import static models.AnimalAttributes.DogColor;
import static models.AnimalAttributes.CatColor;
import static models.AnimalAttributes.Size;

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
        String name = scanner.nextLine();

        System.out.print("Enter animal gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter animal species (CAT/DOG): ");
        Species species = Species.valueOf(scanner.nextLine().toUpperCase());

        Enum<?> color;
        if (species == Species.CAT) {
            System.out.print("Enter cat color (BLACK/WHITE/GRAY/ORANGE/TABBY/CALICO/TORTOISESHELL/MIXED): ");
            color = CatColor.valueOf(scanner.nextLine().toUpperCase());
        } else {
            System.out.print("Enter dog color (BLACK/BROWN/WHITE/GOLDEN/GRAY/MIXED): ");
            color = DogColor.valueOf(scanner.nextLine().toUpperCase());
        }

        System.out.print("Enter animal age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Is the animal vaccinated? (true/false): ");
        boolean vaccinated = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Enter health status: ");
        String healthStatus = scanner.nextLine();

        System.out.print("Enter rescue location: ");
        String locationFound = scanner.nextLine();

        System.out.print("Enter rescuer name: ");
        String rescuerName = scanner.nextLine();

        System.out.print("Enter rescuer contact info: ");
        String rescuerContact = scanner.nextLine();

        StrayAnimal strayAnimal = new StrayAnimal(
            name, 
            gender, 
            species, 
            color, 
            age, 
            Size.MEDIUM, 
            vaccinated, 
            healthStatus, 
            locationFound, 
            LocalDate.now(), 
            rescuerName, 
            rescuerContact
        );
        
        strayAnimals.add(strayAnimal);

        System.out.println("Stray animal intake completed! Details:");
        displayAnimalDetails(strayAnimal);
    }

    public void displayAnimalDetails(StrayAnimal animal) {
        System.out.println("Stray Animal Details:");
        animal.displayInfo();
    }

    public List<StrayAnimal> getStrayAnimals() {
        return strayAnimals;
    }
}

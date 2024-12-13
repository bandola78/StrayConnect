package services;

import models.StrayAnimal;
import models.Volunteer;

import java.util.Scanner;

public class FosterServices {

    public void initiateFoster(Scanner scanner, StrayAnimal strayAnimal) {
        System.out.print("Enter your name: ");
        String fosterName = scanner.nextLine();
        System.out.print("Enter your contact info: ");
        String contactInfo = scanner.nextLine();

        Volunteer fosterVolunteer = new Volunteer(fosterName, contactInfo);
        fosterVolunteer.addRescue(strayAnimal);

        System.out.println("Fostering initiated! Thank you for your help.");
        displayFosterDetails(fosterVolunteer, strayAnimal);
    }

    private void displayFosterDetails(Volunteer volunteer, StrayAnimal animal) {
        System.out.println("Foster Volunteer Details:");
        System.out.println("Name: " + volunteer.getName());
        System.out.println("Contact Info: " + volunteer.getContactInfo());
        System.out.println("Animal Fostered: " + animal.getName() + " (" + animal.getSpecies() + ")");
    }
}

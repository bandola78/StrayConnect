package services;

import models.Volunteer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VolunteerServices {

    private List<Volunteer> volunteers;

    public VolunteerServices() {
        this.volunteers = new ArrayList<>();
    }

    public void registerVolunteer(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your contact info: ");
        String contactInfo = scanner.nextLine();

        Volunteer volunteer = new Volunteer(name, contactInfo);
        volunteers.add(volunteer);

        System.out.println("Volunteer registration completed! Thank you for joining.");
        displayVolunteerDetails(volunteer);
    }

    public void displayVolunteerDetails(Volunteer volunteer) {
        System.out.println("Volunteer Details:");
        System.out.println("Name: " + volunteer.getName());
        System.out.println("Contact Info: " + volunteer.getContactInfo());
        System.out.println("Total Rescues: " + volunteer.getRescueCount());
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }
}

package models;

import java.util.ArrayList;
import java.util.List;

public class Volunteer {
    private String name;
    private String contactInfo;
    private int rescueCount;   
    private List<StrayAnimal> rescuedAnimals; 

    public Volunteer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.rescueCount = 0;  
        this.rescuedAnimals = new ArrayList<>(); 
    }

    public String getName() { 
        return name; 
        }

    public void setName(String name) { 
        this.name = name; 
        }

    public String getContactInfo() { 
        return contactInfo; 
        }

    public void setContactInfo(String contactInfo) { 
        this.contactInfo = contactInfo; 
        }

    public int getRescueCount() { 
        return rescueCount; 
        }

    public void incrementRescueCount() { 
        this.rescueCount++; 
        }

    public List<StrayAnimal> getRescuedAnimals() { 
        return rescuedAnimals; 
        }

    public void addRescue(StrayAnimal animal) {
        rescuedAnimals.add(animal);
        incrementRescueCount(); 
    }

    public void displayVolunteerInfo() {
        System.out.println("Volunteer - Name: " + getName());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Total Rescues: " + getRescueCount());

        System.out.println("Rescued Animals:");
        for (StrayAnimal animal : rescuedAnimals) {
            System.out.println("  - " + animal.getName() + " (" + animal.getSpecies() + ")");
        }
    }

    public static Volunteer registerVolunteer(String name, String contactInfo) {
        return new Volunteer(name, contactInfo);
    }
}

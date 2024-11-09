package models;

import models.AnimalAttributes.Gender;
import models.AnimalAttributes.Species;
import models.AnimalAttributes.Size;


public class RegisteredPet extends Animal {
    private String ownerName;

    public RegisteredPet(String name, Gender gender, Species species, Enum<?> color, int approxAge,
                         Size size, boolean isVaccinated, String healthStatus, String ownerName) {
        super(name, gender, species, color, approxAge, size, isVaccinated, healthStatus);
        this.ownerName = ownerName;
    }

    public String getOwnerName() { 
        return ownerName; 
        }

    public void setOwnerName(String ownerName) { 
        this.ownerName = ownerName; 
        }

    @Override
    public void displayInfo() {
        System.out.println("Registered Pet - Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Species: " + getSpecies())
        System.out.println("Color: " + getColor())
        System.out.println("Age (Approximate): " + getApproxAge());
        System.out.println("Size: " + getSize("S" : "M" : "L"))
        System.out.println("Vaccinated: " + (isVaccinated() ? "Yes" : "No"));
        System.out.println("Health Status: " + getHealthStatus());
        System.out.println("Owner: " + getOwnerName())
    }
}

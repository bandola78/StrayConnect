package models;

import models.AnimalAttributes.Gender;
import models.AnimalAttributes.Species;
import models.AnimalAttributes.Size;

public class RegisteredPet extends Animal {
    private String ownerName;
    private String contactNumber;
    private String address;

    public RegisteredPet(String name, Gender gender, Species species, Enum<?> color, int approxAge,
                         Size size, boolean isVaccinated, String healthStatus, String ownerName,
                         String contactNumber, String address) {
        super(name, gender, species, color, approxAge, size, isVaccinated, healthStatus);
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void displayInfo() {
        System.out.println("Registered Pet - Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Species: " + getSpecies());
        System.out.println("Color: " + getColor());
        System.out.println("Age (Approximate): " + getApproxAge());
        System.out.println("Size: " + getSize());
        System.out.println("Vaccinated: " + (isVaccinated() ? "Yes" : "No"));
        System.out.println("Health Status: " + getHealthStatus());
        System.out.println("Owner: " + getOwnerName());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Address: " + getAddress());
    }
}

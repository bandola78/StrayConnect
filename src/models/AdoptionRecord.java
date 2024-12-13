package models;

import java.time.LocalDate;

public class AdoptionRecord {

    private String adopterName;
    private StrayAnimal adoptedAnimal;
    private LocalDate adoptionDate;

    public AdoptionRecord(String adopterName, StrayAnimal adoptedAnimal, LocalDate adoptionDate) {
        this.adopterName = adopterName;
        this.adoptedAnimal = adoptedAnimal;
        this.adoptionDate = adoptionDate;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public StrayAnimal getAdoptedAnimal() {
        return adoptedAnimal;
    }

    public void setAdoptedAnimal(StrayAnimal adoptedAnimal) {
        this.adoptedAnimal = adoptedAnimal;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public void displayAdoptionInfo() {
        System.out.println("Adoption Record:");
        System.out.println("Adopter Name: " + adopterName);
        System.out.println("Animal Adopted: " + adoptedAnimal.getName() + " (" + adoptedAnimal.getSpecies() + ")");
        System.out.println("Adoption Date: " + adoptionDate);
    }
}

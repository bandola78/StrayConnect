package models;

import models.AnimalAttributes.Gender;
import models.AnimalAttributes.Species;
import models.AnimalAttributes.Size;

import java.time.LocalDate;

public class StrayAnimal extends Animal {
    private String locationFound;
    private LocalDate dateRescued;
    private String rescuerName;
    private String rescuerContact;

    public StrayAnimal(String name, Gender gender, Species species, Enum<?> color, int approxAge,
                       Size size, boolean isVaccinated, String healthStatus, String locationFound,
                       LocalDate dateRescued, String rescuerName, String rescuerContact) 
                       {
        super(name, gender, species, color, approxAge, size, isVaccinated, healthStatus);
        this.locationFound = locationFound;
        this.dateRescued = dateRescued;
        this.rescuerName = rescuerName;
        this.rescuerContact = rescuerContact;
    }

    public String getLocationFound() { 
        return locationFound; 
        }

    public void setLocationFound(String locationFound) { 
        this.locationFound = locationFound; 
        }

    public LocalDate getDateRescued() { 
        return dateRescued; 
        }

    public void setDateRescued(LocalDate dateRescued) { 
        this.dateRescued = dateRescued; 
        }

    public String getRescuerName() { 
        return rescuerName; 
        }

    public void setRescuerName(String rescuerName) { 
        this.rescuerName = rescuerName; 
        }

    public String getRescuerContact() { 
        return rescuerContact; 
        }

    public void setRescuerContact(String rescuerContact) { 
        this.rescuerContact = rescuerContact; 
        }

    @Override
    public void displayInfo() {
        System.out.println("Stray Animal - Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Species: " + getSpecies());
        System.out.println("Color: " + getColor());
        System.out.println("Age (Approximate): " + getApproxAge());
        System.out.println("Size:" + getSize());
        System.out.println("Vaccinated: " + (isVaccinated() ? "Yes" : "No"));
        System.out.println("Health Status: " + getHealthStatus());

        System.out.println("Location Found: " + getLocationFound());
        System.out.println("Date Rescued: " + getDateRescued());
        System.out.println("Rescuer: " + getRescuerName());
        System.out.println("Contact: " + getRescuerContact());
    }
}

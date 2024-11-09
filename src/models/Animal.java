package models;

import models.AnimalAttributes.Gender;
import models.AnimalAttributes.Species;
import models.AnimalAttributes.Size;


public abstract class Animal {
    private String name;
    private Gender gender;
    private Species species;
    private Enum<?> color;          
    private int approxAge; 
    private Size size;         
    private boolean isVaccinated;   
    private String healthStatus;    

    public Animal(String name, Gender gender, Species species, Enum<?> color, int approxAge, Size size, boolean isVaccinated, String healthStatus) {
        this.name = name;
        this.gender = gender;
        this.species = species;
        this.color = color;
        this.approxAge = approxAge;
        this.isVaccinated = isVaccinated;
        this.healthStatus = healthStatus;
    }

    public String getName() { 
        return name; 
        }

    public void setName(String name) { 
        this.name = name; 
        }

    public Gender getGender() { 
        return gender; 
        }

    public void setGender(Gender gender) { 
        this.gender = gender; 
        }

    public Species getSpecies() { 
        return species; 
        }

    public void setSpecies(Species species) { 
        this.species = species; 
        }

    public Enum<?> getColor() { 
        return color; 
        }

    public void setColor(Enum<?> color) { 
        this.color = color; 
        }

    public int getApproxAge() { 
        return approxAge; 
        }

    public void setApproxAge(int approxAge) { 
        this.approxAge = approxAge; 
        }

    public Size getsize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isVaccinated() { 
        return isVaccinated; 
        }

    public void setVaccinated(boolean vaccinated) { 
        this.isVaccinated = vaccinated; 
        }

    public String getHealthStatus() { 
        return healthStatus; 
        }

    public void setHealthStatus(String healthStatus) { 
        this.healthStatus = healthStatus; 
        }

    public abstract void displayInfo();
}

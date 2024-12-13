package models;

import java.time.LocalDate;

public class Donation {
    private String donorName;
    private double amount;          
    private String donationType;    
    private LocalDate donationDate; 

    public Donation(String donorName, double amount, String donationType, LocalDate donationDate) {
        this.donorName = donorName;
        this.amount = amount;
        this.donationType = donationType;
        this.donationDate = donationDate;
    }

    public String getDonorName() { 
        return donorName; 
        }

    public void setDonorName(String donorName) { 
        this.donorName = donorName; 
        }

    public double getAmount() { 
        return amount; 
        }

    public void setAmount(double amount) { 
        this.amount = amount; 
        }

    public String getDonationType() { 
        return donationType; 
        }

    public void setDonationType(String donationType) { 
        this.donationType = donationType; 
        }

    public LocalDate getDonationDate() { 
        return donationDate; 
        }
        
    public void setDonationDate(LocalDate donationDate) { 
        this.donationDate = donationDate; 
        }

    public void displayDonationInfo() {
        System.out.println("Donation - Donor: " + getDonorName());
        System.out.println("Amount: " + amount + ", Type: " + getDonationType());
        System.out.println("Date: " + getDonationDate());
    }
}

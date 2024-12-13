package reports;

import models.*;
import services.*;

import java.util.List;

public class ReportsGenerator {

    public void generateAdoptionReport(List<AdoptionRecord> adoptionRecords) {
        System.out.println("\n=== Adoption Report ===");
        if (adoptionRecords.isEmpty()) {
            System.out.println("No adoptions have been recorded.");
        } else {
            for (AdoptionRecord record : adoptionRecords) {
                record.displayAdoptionInfo();
                System.out.println("------------------------");
            }
        }
    }

    public void generateDonationReport(List<Donation> donations) {
        System.out.println("\n=== Donation Report ===");
        if (donations.isEmpty()) {
            System.out.println("No donations have been recorded.");
        } else {
            double totalAmount = 0;
            for (Donation donation : donations) {
                donation.displayDonationInfo();
                totalAmount += donation.getAmount();
                System.out.println("------------------------");
            }
            System.out.printf("Total Donations: $%.2f\n", totalAmount);
        }
    }

    public void generateVolunteerReport(List<Volunteer> volunteers) {
        System.out.println("\n=== Volunteer Report ===");
        if (volunteers.isEmpty()) {
            System.out.println("No volunteers have registered.");
        } else {
            for (Volunteer volunteer : volunteers) {
                volunteer.displayVolunteerInfo();
                System.out.println("------------------------");
            }
        }
    }
}

package interfaces;

import models.StrayAnimal;

public interface VolunteerActions {

    /**
     * Registers the volunteer's rescue activity.
     * 
     * @param animal The stray animal being rescued.
     */
    void registerRescue(StrayAnimal animal);

    /**
     * Displays the volunteer's activities and contributions.
     */
    void displayVolunteerContributions();
}

package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.utils.ValidationHelper;

public class TicketImpl implements Ticket {
    private final int id;
    private final Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        this.id = id;
        this.journey = journey;
        setAdministrativeCosts(administrativeCosts);
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        validateAdministrativeCosts(administrativeCosts);

        this.administrativeCosts = administrativeCosts;
    }

    private void validateAdministrativeCosts(double administrativeCosts) {
        ValidationHelper.validateCosts(administrativeCosts);
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {

        return "Ticket ----" + System.lineSeparator() +
                "Destination: " + journey.getDestination() + System.lineSeparator() +
                "Price: " + calculatePrice();
    }

}

package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private final int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        this.id = id;
        this.journey = journey;
        this.administrativeCosts = administrativeCosts;
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

package com.company.oop.agency.core;

import com.company.oop.agency.exceptions.ElementNotFoundException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.AirplaneImpl;
import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.TrainImpl;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.core.contracts.AgencyRepository;

import java.util.ArrayList;
import java.util.List;

public class AgencyRepositoryImpl implements AgencyRepository {

    private int nextId;

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Journey> journeys = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();

    public AgencyRepositoryImpl() {
        nextId = 0;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public List<Journey> getJourneys() {
        return new ArrayList<>(journeys);
    }

    @Override
    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    @Override
    public Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : getVehicles()) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }

        throw new ElementNotFoundException(String.format("No record with ID %d", id));
    }

    @Override
    public Journey findJourneyById(int id) {

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Ticket findTicketById(int id) {

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Vehicle createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        Vehicle airplane = new AirplaneImpl(++nextId, passengerCapacity, pricePerKilometer, hasFreeFood);
        this.vehicles.add(airplane);
        return airplane;
    }

    @Override
    public Vehicle createBus(int passengerCapacity, double pricePerKilometer) {
        Vehicle bus = new BusImpl(++nextId, passengerCapacity, pricePerKilometer);
        this.vehicles.add(bus);
        return bus;
    }

    @Override
    public Vehicle createTrain(int passengerCapacity, double pricePerKilometer, int carts) {
        Vehicle train = new TrainImpl(++nextId, passengerCapacity, pricePerKilometer, carts);
        this.vehicles.add(train);
        return train;
    }

    @Override
    public Journey createJourney(String startLocation, String destination, int distance, Vehicle vehicle) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Ticket createTicket(Journey journey, double costs) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Advanced task: Implement the following generic method that looks for an item by id.
    // private <T extends {{?}}> T findElementById(List<T> elements, int id) { }
}
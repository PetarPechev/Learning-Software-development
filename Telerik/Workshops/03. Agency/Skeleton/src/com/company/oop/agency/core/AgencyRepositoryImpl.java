package com.company.oop.agency.core;

import com.company.oop.agency.exceptions.ElementNotFoundException;
import com.company.oop.agency.models.JourneyImpl;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.AirplaneImpl;
import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.TrainImpl;
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
    public <T extends Identifiable> T findElementById(List<T> elements, int id) {
        for (T element : elements) {
            if (element.getId() == id) {
                return element;
            }
        }

        throw new ElementNotFoundException(String.format("No record with ID %d", id));
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
        Journey journey = new JourneyImpl(++nextId, startLocation, destination, distance, vehicle);

        this.journeys.add(journey);

        return journey;
    }


    @Override
    public Ticket createTicket(Journey journey, double administrativeCosts) {
        Ticket ticket = new TicketImpl(++nextId, journey, administrativeCosts);

        this.tickets.add(ticket);

        return ticket;
    }

    @Override
    public Vehicle findVehicleById(int id) {
        return findElementById(getVehicles(), id);

        // Method below is not used anymore,
        // because we implemented the above Generic method.
        // This is part of Advanced Tasks!

        /*for (Vehicle vehicle : getVehicles()) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }

        throw new ElementNotFoundException(String.format("No record with ID %d", id));*/
    }

    @Override
    public Journey findJourneyById(int id) {
        return findElementById(getJourneys(), id);

        // Method below is not used anymore,
        // because we implemented the above Generic method.
        // This is part of Advanced Tasks!

        /*for (Journey journey : getJourneys()) {
            if (journey.getId() == id) {
                return journey;
            }
        }

        throw new ElementNotFoundException(String.format("No record with ID %d", id));*/
    }

    @Override
    public Ticket findTicketById(int id) {
        return findElementById(getTickets(), id);

        // Method below is not used anymore,
        // because we implemented the above Generic method.
        // This is part of Advanced Tasks!

        /*for (Ticket ticket : getTickets()) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }

        throw new ElementNotFoundException(String.format("No record with ID %d", id));*/
    }

}
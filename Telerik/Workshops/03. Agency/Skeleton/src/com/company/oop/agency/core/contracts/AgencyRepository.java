package com.company.oop.agency.core.contracts;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.List;

public interface AgencyRepository {

    List<Ticket> getTickets();

    List<Vehicle> getVehicles();

    List<Journey> getJourneys();

    Ticket findTicketById(int id);

    Vehicle findVehicleById(int id);

    Journey findJourneyById(int id);

    Vehicle createBus(int passengerCapacity, double pricePerKilometer);

    Ticket createTicket(Journey journey, double costs);

    Vehicle createTrain(int passengerCapacity, double pricePerKilometer, int carts);

    Vehicle createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood);

    Journey createJourney(String startLocation, String destination, int distance, Vehicle vehicle);

}
package com.company.oop.agency.utils;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ListingHelpers {

    public static String ticketsToString(List<Ticket> tickets) {
        List<String> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            result.add(ticket.toString());
        }

        return String.join(CommandsConstants.JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }

    public static String vehiclesToString(List<Vehicle> vehicles) {
        List<String> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            result.add(vehicle.toString());
        }

        return String.join(CommandsConstants.JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }

    public static String journeysToString(List<Journey> journeys) {
        List<String> result = new ArrayList<>();
        for (Journey journey : journeys) {
            result.add(journey.toString());
        }

        return String.join(CommandsConstants.JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }

//    public static <T extends Printable> String elementsToString(List<T> elements) {
//    }

}

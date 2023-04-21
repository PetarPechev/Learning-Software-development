package com.company.oop.agency;

import com.company.oop.agency.core.AgencyEngineImpl;
import com.company.oop.agency.models.vehicles.TrainImpl;
import com.company.oop.agency.models.vehicles.VehicleImpl;

import java.util.ArrayList;

public class Startup {

    public static void main(String[] args) {
        AgencyEngineImpl engine = new AgencyEngineImpl();
        engine.start();


    }

}

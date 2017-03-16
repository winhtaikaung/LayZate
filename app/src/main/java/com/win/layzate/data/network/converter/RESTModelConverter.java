package com.win.layzate.data.network.converter;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.domain.model.Arrival;
import com.win.layzate.domain.model.Departure;
import com.win.layzate.domain.model.Flight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class RESTModelConverter {

//    public static RESTFlight convertToRestModel(Flight flight) {
//
//        Departure departure = new Departure(flight.getDeparture().getAirport(),flight.getDeparture().getCountry(),flight.getDeparture().getCountry());
//        Arrival arrival = new Arrival(flight.getArrival().getAirport(),flight.getArrival().getCountry(),flight.getArrival().getCountry());
//
//        RESTFlight restFlight = new RESTFlight(departure,arrival,flight.getName(),flight.getStatus(),flight.getTrackingUrl());
//        return restFlight;
//
//    }

    public Flight convertToFlightModel(RESTFlight restFlight) {

        Departure departure = new Departure(restFlight.getDeparture().getAirport(),
                restFlight.getDeparture().getCountry(),
                restFlight.getDeparture().getCountry());
        Arrival arrival = new Arrival(restFlight.getArrival().getAirport(),
                restFlight.getArrival().getCountry(),
                restFlight.getArrival().getCountry());

        Flight flight = new Flight(restFlight.getName(),
                restFlight.getDate(),
                restFlight.getStatus(),
                restFlight.getTrackingUrl(),
                departure,
                arrival
        );
        return flight;

    }

    public List<Flight>converttoFlightList(List<RESTFlight> restFlightList){
        List<Flight> flightArrayList = new ArrayList<>();
        for(RESTFlight restFlight:restFlightList){
            if(restFlight!=null){
                flightArrayList.add(convertToFlightModel(restFlight));
            }
        }
        return flightArrayList;
    }
}

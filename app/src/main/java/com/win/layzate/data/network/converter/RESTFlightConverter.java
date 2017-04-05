package com.win.layzate.data.network.converter;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.network.model.RESTFlightItem;
import com.win.layzate.data.network.model.RESTFlightList;
import com.win.layzate.domain.model.Arrival;
import com.win.layzate.domain.model.Departure;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.model.FlightItem;
import com.win.layzate.domain.model.FlightList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class RESTFlightConverter {


    /**
     * @param restFlight
     * @return
     */
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

    /**
     * @param restFlightList
     * @return
     */
    public List<Flight> converttoFlightList(List<RESTFlight> restFlightList) {
        List<Flight> flightArrayList = new ArrayList<>();
        for (RESTFlight restFlight : restFlightList) {
            if (restFlight != null) {
                flightArrayList.add(convertToFlightModel(restFlight));
            }
        }
        return flightArrayList;
    }


    /**
     * @param restFlightList
     * @return
     */
    public FlightList converttoFLightList(RESTFlightList restFlightList) {

        FlightList flightList = new FlightList(getFlightList(restFlightList.getFlightItems()));
        return flightList;
    }

    /**
     * @param flightItems
     * @return
     */
    public List<FlightItem> getFlightList(List<RESTFlightItem> flightItems) {
        List<FlightItem> flightItemList = new ArrayList<>();
        for (RESTFlightItem i : flightItems) {
            flightItemList.add(getFLightItem(i));
        }

        return flightItemList;
    }

    /**
     * @param i
     * @return
     */
    public FlightItem getFLightItem(RESTFlightItem i) {
        FlightItem flightItem = new FlightItem(i.getTrackingUrl(),
                i.getNumber(), i.getCarrier(), i.getOriginCode(),
                i.getOriginName(), i.getTime(),
                i.getStatus(), i.getRemark());
        return flightItem;
    }
}

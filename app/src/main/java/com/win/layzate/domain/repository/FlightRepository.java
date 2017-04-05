package com.win.layzate.domain.repository;

import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.model.FlightList;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface FlightRepository {

    Observable<Flight> getFlight(String type, String flightNumber, String flightDate);

    Observable<FlightList> getAllFlights(String type, String queryTime,
                                         boolean isDeparture,
                                         String portcode);
}

package com.win.layzate.domain.repository;

import com.win.layzate.domain.model.Flight;

import java.util.List;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface FlightRepository {

    Flight getFlight();

    List<Flight> getAllFlights();
}

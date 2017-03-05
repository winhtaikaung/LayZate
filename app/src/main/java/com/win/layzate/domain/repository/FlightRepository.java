package com.win.layzate.domain.repository;

import com.win.layzate.domain.model.Flight;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface FlightRepository {

    Observable<Flight> getFlight();

    Observable<List<Flight>> getAllFlights();
}

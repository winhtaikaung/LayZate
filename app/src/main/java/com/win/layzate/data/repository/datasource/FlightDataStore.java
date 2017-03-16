package com.win.layzate.data.repository.datasource;

import com.win.layzate.data.network.model.RESTFlight;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public interface FlightDataStore {

    Observable<List<RESTFlight>> flights();

    Observable<RESTFlight> flight(String type,String flightNumber,String flightDate);
}

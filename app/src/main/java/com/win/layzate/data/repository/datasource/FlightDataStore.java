package com.win.layzate.data.repository.datasource;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.network.model.RESTFlightList;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public interface FlightDataStore {
    /**
     * @param type
     * @param queryTime
     * @param isDeparture
     * @param portcode
     * @return
     */
    Observable<RESTFlightList> flights(String type, String queryTime, boolean isDeparture, String portcode);

    /**
     * @param type
     * @param flightNumber
     * @param flightDate
     * @return
     */
    Observable<RESTFlight> flight(String type, String flightNumber, String flightDate);
}

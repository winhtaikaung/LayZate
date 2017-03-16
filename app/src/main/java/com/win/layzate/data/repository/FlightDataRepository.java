package com.win.layzate.data.repository;

import com.win.layzate.data.network.converter.RESTModelConverter;
import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.repository.datasource.FlightDataStoreFactory;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.repository.FlightRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class FlightDataRepository implements FlightRepository{
    private final RESTModelConverter restModelConverter;
    private final FlightDataStoreFactory flightDataStoreFactory;
    public FlightDataRepository(FlightDataStoreFactory flightDataStoreFactory,RESTModelConverter restModelConverter){
        this.restModelConverter = restModelConverter;
        this.flightDataStoreFactory = flightDataStoreFactory;
    }


    @Override
    public Observable<Flight> getFlight(String type, String flightNumber, String flightDate) {
       return  flightDataStoreFactory.create().flight(type,flightNumber,flightDate).map(new Function<RESTFlight, Flight>() {
           @Override
           public Flight apply(RESTFlight restFlight) throws Exception {
               return restModelConverter.convertToFlightModel(restFlight);
           }
       });
    }

    @Override
    public Observable<List<Flight>> getAllFlights() {
        return null;
    }
}

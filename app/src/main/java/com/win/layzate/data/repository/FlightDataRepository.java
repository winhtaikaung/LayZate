package com.win.layzate.data.repository;

import com.win.layzate.data.network.converter.RESTFlightConverter;
import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.network.model.RESTFlightList;
import com.win.layzate.data.repository.datasource.FlightDataStoreFactory;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.model.FlightList;
import com.win.layzate.domain.repository.FlightRepository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class FlightDataRepository implements FlightRepository{
    private final RESTFlightConverter restFlightConverter;
    private final FlightDataStoreFactory flightDataStoreFactory;

    /**
     *
     * @param flightDataStoreFactory
     * @param restFlightConverter
     */
    public FlightDataRepository(FlightDataStoreFactory flightDataStoreFactory,RESTFlightConverter restFlightConverter){
        this.restFlightConverter = restFlightConverter;
        this.flightDataStoreFactory = flightDataStoreFactory;
    }


    /**
     *
     * @param type
     * @param flightNumber
     * @param flightDate
     * @return
     */
    @Override
    public Observable<Flight> getFlight(String type, String flightNumber, String flightDate) {
       return  flightDataStoreFactory.create().flight(type,flightNumber,flightDate).map(new Function<RESTFlight, Flight>() {
           @Override
           public Flight apply(RESTFlight restFlight) throws Exception {
               return restFlightConverter.convertToFlightModel(restFlight);
           }
       });
    }

    /**
     *
     * @param type
     * @param queryTime
     * @param isDeparture
     * @param portcode
     * @return
     */
    @Override
    public Observable<FlightList> getAllFlights(String type, String queryTime, boolean isDeparture, String portcode) {
        return flightDataStoreFactory.create().flights( type,  queryTime,  isDeparture,  portcode).map(new Function<RESTFlightList, FlightList>() {
            @Override
            public FlightList apply(RESTFlightList restFlightList) throws Exception {
                return restFlightConverter.converttoFLightList(restFlightList);
            }
        });
    }

}

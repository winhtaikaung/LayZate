package com.win.layzate.data.services;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.domain.model.Flight;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by winhtaikaung on 5/3/17.
 */

public interface FlightService {

    @GET("")
    Observable<List<RESTFlight>> getAllFlightList();

    @GET("v1/flight")
    Observable<RESTFlight> getFlight(@Query("type") String type,
                                     @Query("fnumber") String fnumber,
                                     @Query("flightdate") String flightDate);
}

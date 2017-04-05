package com.win.layzate.data.services;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.network.model.RESTFlightList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by winhtaikaung on 5/3/17.
 */

public interface FlightService {
    /**
     * @param type
     * @param queryTime
     * @param isDeparture
     * @param portCode
     * @return
     */
    @GET("v1/flight")
    Observable<RESTFlightList> getAllFlightList(@Query("type") String type,
                                                @Query("queryTime") String queryTime,
                                                @Query("flightType") boolean isDeparture,
                                                @Query("portcode") String portCode);

    /**
     * @param type
     * @param fnumber
     * @param flightDate
     * @return
     */
    @GET("v1/flight")
    Observable<RESTFlight> getFlight(@Query("type") String type,
                                     @Query("fnumber") String fnumber,
                                     @Query("flightdate") String flightDate);
}

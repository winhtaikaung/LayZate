package com.win.layzate.data.services;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.domain.model.Flight;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by winhtaikaung on 5/3/17.
 */

public interface FlightService {

    @GET("")
    Observable<List<RESTFlight>> getAllFlightList();

    @GET("")
    Observable<RESTFlight> getFlight();
}

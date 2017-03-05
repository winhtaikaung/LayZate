package com.win.layzate.data.services;

import com.win.layzate.domain.model.Flight;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 5/3/17.
 */

public interface FlightListService {

  Observable<List<Flight>> getAllFlightList();
}

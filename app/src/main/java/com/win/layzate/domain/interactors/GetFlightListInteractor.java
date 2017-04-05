package com.win.layzate.domain.interactors;

import com.win.layzate.domain.model.FlightList;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface GetFlightListInteractor {
    interface Callback {
        void onFlightlistretrieved(Observable<FlightList> flightList);
    }
}

package com.win.layzate.domain.interactors;

import com.win.layzate.domain.model.Flight;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface GetFlightListInteractor {
    interface Callback{
        void onFlightlistretrieved(Observable<List<Flight>> flightList);
    }
}

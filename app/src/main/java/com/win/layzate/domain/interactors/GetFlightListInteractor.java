package com.win.layzate.domain.interactors;

import com.win.layzate.domain.interactors.base.Interactor;
import com.win.layzate.domain.model.FlightList;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface GetFlightListInteractor extends Interactor{
    interface Callback {
        void onFlightListRetrieved(Observable<FlightList> flightList);
    }
}

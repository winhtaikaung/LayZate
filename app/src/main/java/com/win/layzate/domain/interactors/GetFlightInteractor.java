package com.win.layzate.domain.interactors;

import com.win.layzate.domain.model.Flight;


import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface GetFlightInteractor {
    interface Callback {
        void onFlightretrieved( Observable<Flight> flight);
    }
}

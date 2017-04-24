package com.win.layzate.presentation.presenters;

import com.win.layzate.domain.model.FlightList;
import com.win.layzate.presentation.ui.BaseView;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public interface FlightListPresenter {

    interface View extends BaseView {
        void onFlightListRetrieved(FlightList flightList);
    }

    void getFlightList(String type,String queryTime,boolean isDeparture,String portCode);
}

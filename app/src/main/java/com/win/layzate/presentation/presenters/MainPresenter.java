package com.win.layzate.presentation.presenters;

import com.win.layzate.presentation.ui.BaseView;

/**
 * Created by winhtaikaung on 16/3/17.
 */

public interface MainPresenter {
    interface View extends BaseView {


    }

    void getFlightinfo(String type, String flightNumber, String date);
}

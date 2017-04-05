package com.win.layzate.data.repository.datasource;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.network.model.RESTFlightList;
import com.win.layzate.data.services.FlightService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.win.layzate.data.network.RestClient.getRetrofit;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class FlightCloudDataStore implements FlightDataStore {

    private final String TAG = "FLIGHT_CLOUD_DATA_STORE";


    public FlightCloudDataStore() {

    }

    /**
     * @param type
     * @param queryTime
     * @param isDeparture
     * @param portcode
     * @return
     */
    @Override
    public Observable<RESTFlightList> flights(String type, String queryTime, boolean isDeparture, String portcode) {

        return getRetrofit().create(FlightService.class)
                .getAllFlightList(type, queryTime, isDeparture, portcode)
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<RESTFlightList>() {
                    @Override
                    public void accept(RESTFlightList restFlightList) throws Exception {

                    }
                });
    }

    /**
     * @param type
     * @param flightNumber
     * @param flightDate
     * @return
     */
    @Override
    public Observable<RESTFlight> flight(String type, String flightNumber, String flightDate) {
        return getRetrofit().create(FlightService.class).getFlight(type, flightNumber, flightDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<RESTFlight>() {
                    @Override
                    public void accept(RESTFlight restFlight) throws Exception {

                    }
                });
    }


}

package com.win.layzate.data.repository.datasource;

import android.util.Log;

import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.services.FlightService;
import com.win.layzate.domain.executor.MainThread;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.win.layzate.data.network.RestClient.getRetrofit;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class FlightCloudDataStore implements  FlightDataStore{

    private final String TAG = "FLIGHT_CLOUD_DATA_STORE";


    public FlightCloudDataStore(){

    }

    @Override
    public Observable<List<RESTFlight>> flights() {

        return getRetrofit().create(FlightService.class)
                .getAllFlightList()
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<List<RESTFlight>>() {
            @Override
            public void accept(List<RESTFlight> restFlightList) throws Exception {
                Log.e(TAG+"_LIST",String.valueOf(restFlightList.size()));
            }
        });
    }

    @Override
    public Observable<RESTFlight> flight(String type, String flightNumber, String flightDate) {
        return getRetrofit().create(FlightService.class).getFlight(type,flightNumber,flightDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .doOnNext(new Consumer<RESTFlight>() {
                     @Override
                     public void accept(RESTFlight restFlight) throws Exception {

                     }
                 });
    }


}

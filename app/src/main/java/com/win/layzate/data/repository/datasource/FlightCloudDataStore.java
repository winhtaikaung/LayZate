package com.win.layzate.data.repository.datasource;

import android.util.Log;

import com.win.layzate.data.network.RestClient;
import com.win.layzate.data.network.model.RESTFlight;
import com.win.layzate.data.services.FlightService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

import static com.win.layzate.data.network.RestClient.getRetrofit;
import static com.win.layzate.data.network.RestClient.getService;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class FlightCloudDataStore implements  FlightDataStore{

    private final String TAG = "FLIGHT_CLOUD_DATA_STORE";


    public FlightCloudDataStore(){

    }

    @Override
    public Observable<List<RESTFlight>> flights() {

        return getService(FlightService.class).getAllFlightList().doOnNext(new Consumer<List<RESTFlight>>() {
            @Override
            public void accept(List<RESTFlight> restFlightList) throws Exception {
                Log.e(TAG+"_LIST",String.valueOf(restFlightList.size()));
            }
        });
    }

    @Override
    public Observable<RESTFlight> flight(String type, String flightNumber, String flightDate) {
        return getRetrofit().create(FlightService.class).getFlight(type,flightNumber,flightDate).doOnNext(new Consumer<RESTFlight>() {
            @Override
            public void accept(RESTFlight restFlight) throws Exception {
                Log.e(TAG+"ENTITY",String.valueOf(restFlight.getName()));
            }
        });
    }


}

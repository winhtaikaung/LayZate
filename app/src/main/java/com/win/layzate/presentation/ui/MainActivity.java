package com.win.layzate.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.win.layzate.R;
import com.win.layzate.data.network.converter.RESTModelConverter;
import com.win.layzate.data.repository.FlightDataRepository;
import com.win.layzate.data.repository.datasource.FlightDataStoreFactory;
import com.win.layzate.domain.model.Flight;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FlightCloudDataStore flightCloudDataStore = new FlightCloudDataStore();
////        flightCloudDataStore.flight("single","YH512","2017-03-10");
//
//        Observable<RESTFlight> flight = flightCloudDataStore.flight("single", "YH512", "2017-03-10");
//
//        flight.subscribe(new Consumer<RESTFlight>() {
//            @Override
//            public void accept(RESTFlight restFlight) throws Exception {
//                Log.e("MAIN",restFlight.getName());
//            }
//        });
        FlightDataStoreFactory dataStoreFactory = new FlightDataStoreFactory();
        FlightDataRepository dataRepo = new FlightDataRepository(dataStoreFactory, new RESTModelConverter());
        Observable<Flight> flight = dataRepo.getFlight("single", "YH512", "2017-03-10");
        flight.subscribe(new Consumer<Flight>() {
            @Override
            public void accept(Flight flight) throws Exception {
                Log.e("MAIN",flight.getName());
            }
        });


    }
}

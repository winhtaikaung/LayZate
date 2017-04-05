package com.win.layzate.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.win.layzate.R;
import com.win.layzate.data.network.converter.RESTFlightConverter;
import com.win.layzate.data.repository.FlightDataRepository;
import com.win.layzate.data.repository.datasource.FlightDataStoreFactory;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.model.FlightList;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FlightDataStoreFactory dataStoreFactory = new FlightDataStoreFactory();
        FlightDataRepository dataRepo = new FlightDataRepository(dataStoreFactory, new RESTFlightConverter());
        Observable<Flight> flight = dataRepo.getFlight("single", "YH512", "2017-03-10");
        flight.subscribe(new Consumer<Flight>() {
            @Override
            public void accept(Flight flight) throws Exception {
                Log.e("MAIN", flight.getName());
            }
        });

        Observable<FlightList> flightlist = dataRepo.getAllFlights("list", "8", false, "RGN");
        flightlist.subscribe(new Consumer<FlightList>() {
            @Override
            public void accept(FlightList flightList) throws Exception {
                Log.e("FLIGHTLIST", String.valueOf(flightList.getFlightItems().size()));
            }
        });


    }
}

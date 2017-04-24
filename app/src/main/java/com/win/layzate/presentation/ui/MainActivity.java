package com.win.layzate.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.win.layzate.R;
import com.win.layzate.data.network.converter.RESTFlightConverter;
import com.win.layzate.data.repository.FlightDataRepository;
import com.win.layzate.data.repository.datasource.FlightDataStoreFactory;
import com.win.layzate.domain.executor.impl.ThreadExecutor;
import com.win.layzate.domain.model.FlightList;
import com.win.layzate.presentation.presenters.FlightListPresenter;
import com.win.layzate.presentation.presenters.impl.FlightListPresenterImpl;
import com.win.layzate.threading.MainThreadImpl;

public class MainActivity extends AppCompatActivity implements FlightListPresenter.View {

    private FlightListPresenter mFlightListPresenter;
    private FlightDataStoreFactory mFlightDataStoreFactory;
    private FlightDataRepository mFlightDataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlightDataStoreFactory = new FlightDataStoreFactory();
        mFlightDataRepository = new FlightDataRepository(mFlightDataStoreFactory, new RESTFlightConverter());
        mFlightListPresenter = new FlightListPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, mFlightDataRepository);

        mFlightListPresenter.getFlightList("list", "8", false, "RGN");
    }

    @Override
    public void onFlightListRetrieved(FlightList flightList) {
        Log.e("FlightList_COUNT", String.valueOf(flightList.getFlightItems().size()));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }


//        FlightDataStoreFactory dataStoreFactory = new FlightDataStoreFactory();
//        FlightDataRepository dataRepo = new FlightDataRepository(dataStoreFactory, new RESTFlightConverter());
//        Observable<Flight> flight = dataRepo.getFlight("single", "YH512", "2017-03-10");
//        flight.subscribe(new Consumer<Flight>() {
//            @Override
//            public void accept(Flight flight) throws Exception {
//                Log.e("MAIN", flight.getName());
//            }
//        });
//
//        Observable<FlightList> flightlist = dataRepo.getAllFlights("list", "8", false, "RGN");
//        flightlist.subscribe(new Consumer<FlightList>() {
//            @Override
//            public void accept(FlightList flightList) throws Exception {
//                Log.e("FLIGHTLIST", String.valueOf(flightList.getFlightItems().size()));
//            }
//        });
}

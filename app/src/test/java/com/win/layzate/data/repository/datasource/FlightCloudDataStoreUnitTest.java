package com.win.layzate.data.repository.datasource;

import com.win.layzate.data.network.model.RESTFlight;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 15/3/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightCloudDataStoreUnitTest {

    private FlightCloudDataStore flightCloudDataStore;

    @Test
    public void testGetSingleFlightCloud(){
        flightCloudDataStore = new FlightCloudDataStore();

        Observable<RESTFlight> restFlight = flightCloudDataStore.flight("single","YH512","2017-03-10");

        restFlight.
    }

}

package com.win.layzate.data.repository.datasource;

import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by winhtaikaung on 15/3/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightCloudDataStoreUnitTest {

    private FlightCloudDataStore flightCloudDataStore;

    @Test
    public void testGetSingleFlightCloud(){
        flightCloudDataStore = new FlightCloudDataStore();
        flightCloudDataStore.flight("single","YH512","2017-03-10");
    }

}

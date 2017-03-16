package com.win.layzate.data.repository.datasource;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class FlightDataStoreFactory {

    public FlightDataStoreFactory() {

    }

    public FlightDataStore create() {
        return new FlightCloudDataStore();
    }
}

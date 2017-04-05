package com.win.layzate.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by winhtaikaung on 4/4/17.
 */

public class FlightList {
    @SerializedName("flightItems")
    @Expose
    private List<FlightItem> flightItems = null;

    /**
     * No args constructor for use in serialization
     */
    public FlightList() {
    }

    /**
     * @param flightItems
     */
    public FlightList(List<FlightItem> flightItems) {
        super();
        this.flightItems = flightItems;
    }

    public List<FlightItem> getFlightItems() {
        return flightItems;
    }

    public void setFlightItems(List<FlightItem> flightItems) {
        this.flightItems = flightItems;
    }

}

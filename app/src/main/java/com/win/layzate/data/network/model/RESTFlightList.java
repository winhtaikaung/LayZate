package com.win.layzate.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by winhtaikaung on 4/4/17.
 */

public class RESTFlightList {
    @SerializedName("flightItems")
    @Expose
    private List<RESTFlightItem> flightItems = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public RESTFlightList() {
    }

    /**
     *
     * @param flightItems
     */
    public RESTFlightList(List<RESTFlightItem> flightItems) {
        super();
        this.flightItems = flightItems;
    }

    public List<RESTFlightItem> getFlightItems() {
        return flightItems;
    }

    public void setFlightItems(List<RESTFlightItem> flightItems) {
        this.flightItems = flightItems;
    }

}

package com.win.layzate.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class RESTFlight {

    @SerializedName("departure")
    @Expose
    private RESTDeparture departure;
    @SerializedName("arrival")
    @Expose
    private RESTArrival arrival;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("trackingUrl")
    @Expose
    private String trackingUrl;


    public RESTFlight(RESTDeparture departure, RESTArrival arrival, String name, String status, String trackingUrl) {
        this.departure = departure;
        this.arrival = arrival;
        this.name = name;
        this.status = status;
        this.trackingUrl = trackingUrl;
    }

    public RESTDeparture getDeparture() {
        return departure;
    }

    public void setDeparture(RESTDeparture departure) {
        this.departure = departure;
    }

    public RESTArrival getArrival() {
        return arrival;
    }

    public void setArrival(RESTArrival arrival) {
        this.arrival = arrival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

}

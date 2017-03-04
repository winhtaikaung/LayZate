package com.win.layzate.domain.model;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class Flight {

    private Departure departure;
    private Arrival arrival;
    private String name;
    private String date;
    private String status;
    private String trackingUrl;



    public Flight(String name,String date,String status,String trackingUrl,Departure departure,Arrival arrival){
        this.name = name;
        this.date = date;
        this.status = status;
        this.trackingUrl = trackingUrl;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
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

    @Override
    public String toString() {
        return "Flight name "+this.name+"\t"+this.status;
    }
}

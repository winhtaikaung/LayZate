package com.win.layzate.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by winhtaikaung on 15/3/17.
 */

public class Departure {

    @SerializedName("airport")
    @Expose
    private String airport;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("time")
    @Expose
    private String time;

    public Departure(String airport,String country,String time){

        this.airport = airport;
        this.country = country;
        this.time = time;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

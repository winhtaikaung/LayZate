package com.win.layzate.data.network.model;

/**
 * Created by winhtaikaung on 4/4/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RESTFlightItem {

    @SerializedName("trackingUrl")
    @Expose
    private String trackingUrl;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("carrier")
    @Expose
    private String carrier;
    @SerializedName("originCode")
    @Expose
    private String originCode;
    @SerializedName("originName")
    @Expose
    private String originName;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("remark")
    @Expose
    private String remark;

    /**
     * No args constructor for use in serialization
     */
    public RESTFlightItem() {
    }

    /**
     * @param time
     * @param trackingUrl
     * @param remark
     * @param status
     * @param originCode
     * @param carrier
     * @param number
     * @param originName
     */
    public RESTFlightItem(String trackingUrl, String number, String carrier, String originCode, String originName, String time, String status, String remark) {
        super();
        this.trackingUrl = trackingUrl;
        this.number = number;
        this.carrier = carrier;
        this.originCode = originCode;
        this.originName = originName;
        this.time = time;
        this.status = status;
        this.remark = remark;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

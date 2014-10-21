package entity; 
 /*
 * Copyright 2014 Win Htaik Aung
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created by jr on 10/21/14.
 */
public class Flight {
    private String flightname;
    private String carrier;
    private String origin_destination;
    private String arrival_departure_time;
    private String status;

    public String getFlightname() {
        return flightname;
    }

    public void setFlightname(String flightname) {
        this.flightname = flightname;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }





    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArrival_departure_time() {
        return arrival_departure_time;
    }

    public void setArrival_departure_time(String arrival_departure_time) {
        this.arrival_departure_time = arrival_departure_time;
    }

    public String getOrigin_destination() {
        return origin_destination;
    }

    public void setOrigin_destination(String origin_destination) {
        this.origin_destination = origin_destination;
    }
}

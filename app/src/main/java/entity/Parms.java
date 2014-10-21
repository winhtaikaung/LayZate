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
public class Parms {

    private String language;
    private String startAction;
    private int airportQueryTimePeriod;
    private String imageColor;
    private String airportQueryType;


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStartAction() {
        return startAction;
    }

    public void setStartAction(String startAction) {
        this.startAction = startAction;
    }

    public int getAirportQueryTimePeriod() {
        return airportQueryTimePeriod;
    }

    public void setAirportQueryTimePeriod(int airportQueryTimePeriod) {
        this.airportQueryTimePeriod = airportQueryTimePeriod;
    }

    public String getImageColor() {
        return imageColor;
    }

    public void setImageColor(String imageColor) {
        this.imageColor = imageColor;
    }

    public String getAirportQueryType() {
        return airportQueryType;
    }

    public void setAirportQueryType(String airportQueryType) {
        this.airportQueryType = airportQueryType;
    }
}

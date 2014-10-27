package model; 
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

import android.util.Log;

import org.jsoup.Jsoup;
import android.content.Context;

import com.epicmyanmar.layzate.MainActivity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dbassist.dbhelp;
import entity.Airport;
import entity.Flight;

/**
 * Created by jr on 10/21/14.
 */
public class Dal {
    dbhelp dbhelper;


    private static Dal dal;
    public static Dal instance(){
        if(dal==null){

            dal=new Dal();
        }
        return dal;
    }



    /**
     * Method To get List of Flight by passing Response HTML String to it
     * */
    public List<Flight> getflightList(String Response){
        List<Flight> flist=new ArrayList<Flight>();
        try {

            //Using Jsoup to convert html to objects
            Document doc;
            doc=Jsoup.parse(Response);

            Elements flightList;
            flightList=doc.body().select(".tableListingTable>tbody").select("tr");
            if(flightList.size()>1) {
                flightList.remove(0);
                for(int i=0;i<flightList.size();i++)
                {
                    Flight oFlight=new Flight();
                    oFlight.setFlightname(flightList.get(i).select("td").get(0).text());
                    oFlight.setCarrier(flightList.get(i).select("td").get(1).text());
                    oFlight.setOrigin_destination(flightList.get(i).select("td").get(2).text());
                    oFlight.setArrival_departure_time(flightList.get(i).select("td").get(3).text());
                    oFlight.setStatus(flightList.get(i).select("td").get(4).text());

                    flist.add(oFlight);

                }

            return flist;

            }
            else{

            }
        } catch (Exception e) {
            Log.e("Xml ParseError", e.getMessage());
        }

    return flist;

    }

    public ArrayList<Airport> getAirportList(Context mContext){
        //dbhelper=new dbhelp(getClass().);
        dbhelper=new dbhelp(mContext);
        ArrayList<Airport> mList=new ArrayList<Airport>();

        String SQL="SELECT * FROM tb_airport ORDER BY port_name";
        ArrayList dTable;
        try{
            dTable= dbhelper.getDataTable(SQL);
            for(int i=0;i<dTable.size();i++){

                HashMap dRow=new HashMap();
                dRow=(HashMap) dTable.get(i);
                Airport o=new Airport();
                o.setPort_name(dRow.get("port_name").toString());
                o.setPort_code(dRow.get("port_code").toString());

                mList.add(o);

            }
        }catch(Exception e){
                Log.e("Database error",e.getMessage().toString());
        }
        return mList;
    }
}

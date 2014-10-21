package com.epicmyanmar.layzate;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

import cControls.Custom_Flightlist_Adapter;
import entity.Flight;
import model.Dal;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlightListFragment extends Fragment {
    private static final String URL_STRING_REQ = "http://www.flightstats.com/go/weblet?guid=34b64945a69b9cac:a51bccf:12d54dfa33f:-5bfe&weblet=status&action=AirportFlightStatus&airportCode=RGN";
    private Custom_Flightlist_Adapter custom_flightlist_adapter;
    List<Flight> mFlightListItem=new ArrayList<Flight>();
    ListView listView;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  makeStringReq();

        Flight f1=new Flight();
        f1.setFlightname("ASDF");
        f1.setCarrier("asdf");
        f1.setStatus("asdfasdf");
        f1.setArrival_departure_time("13:14 PM");
        f1.setOrigin_destination("America");
        mFlightListItem.add(f1);

        custom_flightlist_adapter=new Custom_Flightlist_Adapter(getActivity(),mFlightListItem);
        View view=inflater.inflate(R.layout.fragment_flight_list,container,false);
        listView=(ListView) view.findViewById(R.id.listview_flight);
        try {
            listView.setAdapter(custom_flightlist_adapter);
        }catch(Exception e){
            Log.e("List error",e.getMessage());
        }
        return view;


    }



    private void makeStringReq() {
        //showProgressDialog();

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest strReq = new StringRequest(Request.Method.GET,
                URL_STRING_REQ, new Response.Listener<String>() {
            List<Flight> flist=new ArrayList<Flight>();

            @Override
            public void onResponse(String response) {

                Dal dal=new Dal();
                mFlightListItem=dal.getflightList(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        queue.add(strReq);

    }


}

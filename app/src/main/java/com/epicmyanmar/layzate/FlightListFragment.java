package com.epicmyanmar.layzate;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.InjectView;
import cControls.Custom_Flightlist_Adapter;
import dbassist.dbhelp;
import entity.Flight;
import model.Dal;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlightListFragment extends Fragment {
    private static final String URL_STRING_REQ = "http://www.flightstats.com/go/weblet?guid=34b64945a69b9cac:a51bccf:12d54dfa33f:-5bfe&weblet=status&action=AirportFlightStatus&airportCode=RGN";
    private static final String URL_STRING_NO_LOCATION = "http://www.flightstats.com/go/weblet?guid=34b64945a69b9cac:a51bccf:12d54dfa33f:-5bfe&weblet=status&action=AirportFlightStatus&airportCode=";
    private Custom_Flightlist_Adapter custom_flightlist_adapter;
    List<Flight> mFlightListItem=new ArrayList<Flight>();
    ListView listView;
    private ProgressDialog pDialog;



        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            final Bundle bundle = this.getArguments();
            setHasOptionsMenu(true);
       // getActivity().getActionBar().setTitle("Current Departure");

           Toast.makeText(getActivity(),bundle.getString("Airport").toString(),Toast.LENGTH_SHORT).show();



        View view=inflater.inflate(R.layout.fragment_flight_list,container,false);

        listView=(ListView) view.findViewById(R.id.listview_flight);

            pDialog = new ProgressDialog(getActivity());
            // Showing progress dialog before making http request
            pDialog.setMessage("Loading...");
            pDialog.show();

            // changing action bar color
            getActivity().getActionBar().setBackgroundDrawable(
                    new ColorDrawable(Color.parseColor("#1b1b1b")));
            /*
            * Volley Http Request with list Adapter Binding
            * */
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            StringRequest strReq = new StringRequest(Request.Method.POST,(bundle.getString("Airport").isEmpty())?
                    URL_STRING_REQ:URL_STRING_NO_LOCATION+bundle.getString("Airport"), new Response.Listener<String>() {
                List<Flight> flist=new ArrayList<Flight>();

                @Override
                public void onResponse(String response) {
                    hidePDialog();
                    Dal dal=new Dal();

                    mFlightListItem=dal.getflightList(response);
                    if(mFlightListItem.size()==0) {

                        custom_flightlist_adapter = new Custom_Flightlist_Adapter(getActivity(), mFlightListItem);
                        listView.setAdapter(custom_flightlist_adapter);
                        custom_flightlist_adapter.notifyDataSetChanged();
                        MainActivity.txt_status.setText("No Flight Information \n \nPlease Try again Later");
                    }else{
                        custom_flightlist_adapter = new Custom_Flightlist_Adapter(getActivity(), mFlightListItem);
                        listView.setAdapter(custom_flightlist_adapter);
                        custom_flightlist_adapter.notifyDataSetChanged();
                    }


                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d("Error", "Error: " + error.getMessage());

                }
            }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("language","");
                    params.put("startAction","AirportFlightStatus");
                    params.put("airportQueryTimePeriod", bundle.getString("airportQueryTimePeriod"));
                    params.put("imageColor","orange");
                    params.put("airportQueryType",bundle.getString("airportQueryType"));

                    return params;
                }


            };

            // Adding request to request queue
            queue.add(strReq);
            /*
            * add click listener on each items
            * */
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String forecast=mFlightListItem.get(i).getArrival_departure_time();
                    Toast.makeText(getActivity(),forecast,Toast.LENGTH_SHORT).show();
                }
            });


        return view;


    }


    private void showdetailDialog(){

    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


    private void makeStringReq() {
        //showProgressDialog();

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest strReq = new StringRequest(Request.Method.POST,
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
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("language", "English");
                params.put("startAction", "AirportFlightStatus");
                params.put("airportQueryTimePeriod", "5");
                params.put("imageColor", "orange");
                params.put("airportQueryType", "0");

                return params;
            }
        };

        // Adding request to request queue
        queue.add(strReq);
        //AppController.getInstance().addToRequestQueue(strReq);

    }


}

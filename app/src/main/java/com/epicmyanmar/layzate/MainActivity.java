package com.epicmyanmar.layzate;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import entity.Flight;
import model.Dal;


public class MainActivity extends Activity {
    private static final String URL_STRING_REQ = "http://www.flightstats.com/go/weblet?guid=34b64945a69b9cac:a51bccf:12d54dfa33f:-5bfe&weblet=status&action=AirportFlightStatus&airportCode=RGN";
//   / private String TAG = MainActivity.class.getSimpleName();

    private String tag_string_req = "string_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState==null){
          getFragmentManager().beginTransaction().add(R.id.container,new FlightListFragment()).commit();
        }

          // makeStringReq(URL_STRING_REQ);
          // postStringReq(URL_STRING_REQ);
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        /**
         * Making json object request
         * */

    /**
    *
    * This Method Make Get Request with Volley & Manipulate Response with Jsoup
    * */
    private void makeStringReq(String url) {
        //showProgressDialog();

        RequestQueue queue = Volley.newRequestQueue(getApplication());
        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            List<Flight> flist=new ArrayList<Flight>();

            @Override
            public void onResponse(String response) {


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

    /**
     *
     * This Method Make Post Request with some URL parameter with volley & Manipulate Response with Jsoup
     * */
    private void postStringReq(String url) {
        //showProgressDialog();

        RequestQueue queue = Volley.newRequestQueue(getApplication());
        StringRequest strReq = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {

            //call back function from Google volley
            @Override
            public void onResponse(String response) {
                       //getting data from flightlist



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
                params.put("language","English");
                params.put("startAction","AirportFlightStatus");
                params.put("airportQueryTimePeriod", "5");
                params.put("imageColor","orange");
                params.put("airportQueryType","0");

                return params;
            }


        };

        // Adding request to request queue
        queue.add(strReq);

    }


}

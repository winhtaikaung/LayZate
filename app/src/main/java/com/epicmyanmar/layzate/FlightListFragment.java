package com.epicmyanmar.layzate;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
import java.util.Locale;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cControls.Custom_Flightlist_Adapter;
import dbassist.dbhelp;
import entity.Flight;
import me.drakeet.materialdialog.MaterialDialog;
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
        setHasOptionsMenu(true);

        final Bundle bundle = this.getArguments();
        String ss= Locale.getDefault().toString();
        if(Locale.getDefault().toString().equals("my_MM")){
            getActivity().getActionBar().setTitle(bundle.getString("port_name")+" မှ "+bundle.getString("query_type").toString() + " မည့်စာရင်း" );
        }else {
            getActivity().getActionBar().setTitle(bundle.getString("query_type").toString() + " List on " + bundle.getString("port_name"));
        }

        setHasOptionsMenu(true);
        // getActivity().getActionBar().setTitle("Current Departure");

        Toast.makeText(getActivity(),bundle.getString("Airport").toString(),Toast.LENGTH_SHORT).show();



        View view=inflater.inflate(R.layout.fragment_flight_list,container,false);



        // changing action bar coloro

            /*
            * Volley Http Request with list Adapter Binding
            * */

        boolean connection =checkConnection();
        if(connection)
        {
            listView=(ListView) view.findViewById(R.id.listview_flight);

            pDialog = new ProgressDialog(getActivity());
            // Showing progress dialog before making http request
            pDialog.setTitle(getResources().getString(R.string.progress_title));
            pDialog.setMessage(getResources().getString(R.string.progress_message));
            pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest strReq = new StringRequest(Request.Method.POST, (bundle.getString("Airport").isEmpty()) ?
                URL_STRING_REQ : URL_STRING_NO_LOCATION + bundle.getString("Airport"), new Response.Listener<String>() {
            List<Flight> flist = new ArrayList<Flight>();

            @Override
            public void onResponse(String response) {
                hidePDialog();
                Dal dal = new Dal();

                mFlightListItem = dal.getflightList(response);
                if (mFlightListItem.size() == 0) {

                    custom_flightlist_adapter = new Custom_Flightlist_Adapter(getActivity(), mFlightListItem);
                    listView.setAdapter(custom_flightlist_adapter);
                    custom_flightlist_adapter.notifyDataSetChanged();
                    MainActivity.txt_status.setText(getResources().getString(R.string.no_flightdata));
                } else {
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
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("language", "");
                params.put("startAction", "AirportFlightStatus");
                params.put("airportQueryTimePeriod", bundle.getString("airportQueryTimePeriod"));
                params.put("imageColor", "orange");
                params.put("airportQueryType", bundle.getString("airportQueryType"));

                return params;
            }


        };

        // Adding request to request queue
        queue.add(strReq);
            /*
            * add click listener on each items
            * */
        listView.setOnItemClickListener(new ListViewOnItemclickListener());
    }else{
            MainActivity.txt_status.setText(getResources().getString(R.string.no_connection));
    }


        return view;


    }

    public class ListViewOnItemclickListener implements AdapterView.OnItemClickListener{
        @InjectView(R.id.tv_status) TextView tv_status;
        @InjectView(R.id.tvCarriername) TextView tvCarriername;
        @InjectView(R.id.tvOrigin_Destination) TextView tvOrigin_Destination;
        @InjectView(R.id.tv_Arrival_Departure_time) TextView tv_Arrival_Departure_time;
        @InjectView(R.id.tvFlightname) TextView tvFlightname;

       // @InjectView(R.id.btn_ok) Button btn_ok;
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


               Flight mflight = new Flight();
               mflight = mFlightListItem.get(i);
               View customview=LayoutInflater.from(getActivity()).inflate(R.layout.dialog_flight_detail,null);
               final MaterialDialog materialDialog=new MaterialDialog(getActivity())
                       .setContentView(customview)

                       .setTitle(getResources().getString(R.string.dialog_filght_info));
               materialDialog.setPositiveButton(getResources().getString(R.string.dialog_btn_gotit),new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       materialDialog.dismiss();
                   }
               });
               ButterKnife.inject(this,customview);
                tvFlightname.setText(mflight.getFlightname().toString());
                tvCarriername.setText(mflight.getCarrier().toString());
                tvOrigin_Destination.setText(mflight.getOrigin_destination());
                tv_Arrival_Departure_time.setText(mflight.getArrival_departure_time());
                tv_status.setText(mflight.getStatus());

               materialDialog.show();


        }
    }

    private boolean checkConnection(){

        ConnectivityManager connectManager=(ConnectivityManager)this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();

        boolean isConnected = networkInfo != null &&
                networkInfo.isConnectedOrConnecting();
        if(isConnected){
            return true;
        }else{
            return false;
        }

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
            dialog.setTitle("About");
            dialog.setMessage(getResources().getString(R.string.about_dialogtext));
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }
}

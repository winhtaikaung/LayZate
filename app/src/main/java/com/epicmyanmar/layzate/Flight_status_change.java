package com.epicmyanmar.layzate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cControls.Airport_spinner_adapter;
import cControls.TimePeriod_spinner_adapter;
import dbassist.dbhelp;
import entity.Airport;
import entity.TimePeriod;
import model.Dal;


public class Flight_status_change extends Activity {

    @InjectView(R.id.query_time_spin) Spinner mTimePeriod;
    @InjectView(R.id.query_airport_spin) Spinner mAirport;
    @InjectView(R.id.btn_query)
    FloatingActionButton btn_Query;
    @InjectView(R.id.rdoGroupStatus)  RadioGroup rdo_groupstatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().setTitle("Select Airport & Time");
        super.onCreate(savedInstanceState);

        dbhelp dbhelper=new dbhelp(this);
        dbhelper.MakeDB();
        Dal dal=new Dal();

        final ArrayList<TimePeriod> mlist=new ArrayList<TimePeriod>();
        final ArrayList<Airport> mAirportList=new ArrayList<Airport>();



        setContentView(R.layout.flight_status_change);
        ButterKnife.inject(this);



        String[] myArray = getResources().getStringArray(R.array.query_time_period);


        for(int i=0;i<myArray.length;i++){
            TimePeriod tItem=new TimePeriod();
            tItem.setPeriod(myArray[i].toString());
            tItem.setValue(i);
            mlist.add(tItem);
        }
        for(Airport a:dal.getAirportList(this)){
            mAirportList.add(a);
        }

        Calendar c=Calendar.getInstance();
        Time t=new Time();
        Toast.makeText(this,""+c.getTime().getHours()+"",Toast.LENGTH_LONG).show();

        Airport_spinner_adapter mairport_spin_adapter=new Airport_spinner_adapter(this,android.R.layout.simple_spinner_item,mAirportList);

        TimePeriod_spinner_adapter mtime_spin_adapter=new TimePeriod_spinner_adapter(this,android.R.layout.simple_spinner_item,mlist);

        mTimePeriod.setAdapter(mtime_spin_adapter);
        mAirport.setAdapter(mairport_spin_adapter);

        btn_Query.setOnClickListener(new View.OnClickListener() {
            RadioButton rdostatus;
            @Override
            public void onClick(View view) {
                rdostatus=(RadioButton) findViewById(rdo_groupstatus.getCheckedRadioButtonId());
                TimePeriod t=mlist.get(mTimePeriod.getSelectedItemPosition());
                Airport a=mAirportList.get(mAirport.getSelectedItemPosition());

                int entrytype=(rdostatus.getId()==R.id.rdo_deperture)?0:1;
                Toast.makeText(getApplication(),rdostatus.getText().toString()+""+t.getValue()+""+a.getPort_name()+""+entrytype+"",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("airportQueryTimePeriod",""+t.getValue()+"");
                intent.putExtra("airportQueryType",""+entrytype+"");
                intent.putExtra("Airport",""+a.getPort_code()+"");
                intent.putExtra("txt_querytype",rdostatus.getText().toString());
                intent.putExtra("txt_portname",a.getPort_name().toString());
                startActivity(intent);
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Flight_status_change.this);
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

        return true;
    }
}

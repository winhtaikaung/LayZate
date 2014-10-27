package com.epicmyanmar.layzate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
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
    @InjectView(R.id.btn_query) Button btn_Query;
    @InjectView(R.id.rdoGroupStatus)  RadioGroup rdo_groupstatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().setTitle("Change Your Flight List");
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


        final Airport_spinner_adapter mairport_spin_adapter=new Airport_spinner_adapter(this,android.R.layout.simple_spinner_item,mAirportList);

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


                Toast.makeText(getApplication(),""+t.getValue()+""+a.getPort_code(),Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flight_status_change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}

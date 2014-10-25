package com.epicmyanmar.layzate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cControls.TimePeriod_spinner_adapter;
import entity.TimePeriod;


public class Flight_status_change extends Activity {

    @InjectView(R.id.query_time_spin) Spinner mTimePeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().setTitle("Change Your Flight List");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_status_change);
        ButterKnife.inject(this);
        ArrayList<TimePeriod> mlist=new ArrayList<TimePeriod>();

        TimePeriod t1=new TimePeriod();
        t1.setPeriod("1");
        t1.setValue(0);


        TimePeriod t2=new TimePeriod();
        t2.setPeriod("2");
        t2.setValue(1);
        TimePeriod t3=new TimePeriod();
        t3.setPeriod("3");
        t3.setValue(2);
        mlist.add(t1);
        mlist.add(t2);
        mlist.add(t3);



        TimePeriod_spinner_adapter mtime_spin_adapter=new TimePeriod_spinner_adapter(this,android.R.layout.simple_spinner_item,mlist);

        mTimePeriod.setAdapter(mtime_spin_adapter);


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

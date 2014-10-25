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

import butterknife.ButterKnife;
import butterknife.InjectView;


public class Flight_status_change extends Activity {

    @InjectView(R.id.query_time_spin) Spinner mTimePeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().setTitle("Change Your Flight List");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_status_change);
        ButterKnife.inject(this);
        ArrayAdapter<CharSequence> query_timespin_adapter=ArrayAdapter.createFromResource(this,R.array.query_time_period,android.R.layout.simple_spinner_item);
        query_timespin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTimePeriod.setAdapter(query_timespin_adapter);


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

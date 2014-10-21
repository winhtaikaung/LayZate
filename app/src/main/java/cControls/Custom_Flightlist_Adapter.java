package cControls; 
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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.epicmyanmar.layzate.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import entity.Flight;

/**
 * Created by jr on 10/21/14.
 */
public class Custom_Flightlist_Adapter extends ArrayAdapter {

    Context context;
    List<Flight> mFlights;
    /**
     * Public Constructor for ArrayAdapter
     * */
    public Custom_Flightlist_Adapter(Context _context, List<Flight> Flightlist) {
        super(_context, R.layout.flight_item, Flightlist);
        this.context=_context;
        this.mFlights=Flightlist;
    }
    /**
     * Overriden Method for Overiding the View Inflation
     * @param position Position Indexer for ArrayAdapter
     * @param view View to be inflated
     * @param parent ViewGroup to make parent
     * @return view Return View
     * */
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if(view!=null){
            holder=(ViewHolder) view.getTag();
        }else{
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.flight_item,null);

            holder = new ViewHolder(view);

            view.setTag(holder);

        }

        holder.flightname.setText(mFlights.get(position).getFlightname());
        holder.arriv_depart_time.setText(mFlights.get(position).getArrival_departure_time());
        holder.origin_destination.setText(mFlights.get(position).getOrigin_destination());

        return view;
    }

    /**
     *
     * making TextViews to be reusable ViewHolder
     * All View Elements for List Adapter will be declared here
     *
     */
    static class ViewHolder{
      @InjectView(R.id.txtflightname)  TextView flightname;
      @InjectView(R.id.txt_arrival_departure)  TextView arriv_depart_time;
      @InjectView(R.id.txt_origin_destination)  TextView origin_destination;
        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}

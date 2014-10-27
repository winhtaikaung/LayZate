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

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import entity.Airport;


/**
 * Created by jr on 10/26/14.
 */
public class Airport_spinner_adapter extends ArrayAdapter<Airport> {
    private Context context;
    private ArrayList<Airport> mairportlist ;



    public Airport_spinner_adapter(Context _context,int textViewResourceId,ArrayList<Airport> _mairportlist){
        super(_context,textViewResourceId, _mairportlist);

        this.context=_context;
        this.mairportlist=_mairportlist;

    }
    /*
    * Overide and load th customView in spinner
    * */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    /*
   * Overide and load th customView in spinner
   * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView!=null){
            holder=(ViewHolder) convertView.getTag();
        }
        else{
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView =inflater.inflate(R.layout.airport_spinner_row,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        /*
        * Getting Position of Array and get object inside array
        * */
        Airport t=mairportlist.get(position);
        holder.txt_airport_name.setText(t.getPort_name());

        return convertView;
    }
    /*
    * View Holder to save the memory
    * */
    static class ViewHolder{
        @InjectView(R.id.txt_airport_name)
        TextView txt_airport_name;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
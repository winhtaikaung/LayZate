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
import android.widget.ArrayAdapter;

import com.epicmyanmar.layzate.R;

import java.util.List;

import entity.Flight;

/**
 * Created by jr on 10/21/14.
 */
public class Custom_Flightlist_Adapter extends ArrayAdapter {

    Context context;
    List<Flight> mFlights;

    public Custom_Flightlist_Adapter(Context _context, List<Flight> Flightlist) {
        super(_context, R.layout.flight_item, Flightlist);
        this.mFlights=Flightlist;
    }
}

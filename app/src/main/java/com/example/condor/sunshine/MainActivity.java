package com.example.condor.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //We first create the array
            String[] forecastArray = {
                    "Today - Sunny - 24 / 20",
                    "Tomorrow - Foggy - 21 / 17",
                    "Weds - Cloudy - 22 / 20",
                    "Thurs - Rainy - 20 / 15",
                    "Fri - Foggy - 24 / 22",
                    "Sat - Sunny - 30 / 26",
                    "Sun - Sunny - 35 / 29",
                    "Today - Sunny - 24 / 20",
                    "Tomorrow - Foggy - 21 / 17",
                    "Weds - Cloudy - 22 / 20",
                    "Thurs - Rainy - 20 / 15",
                    "Fri - Foggy - 24 / 22",
                    "Sat - Sunny - 30 / 26",
                    "Sun - Sunny - 35 / 29",
                    "Today - Sunny - 24 / 20",
                    "Tomorrow - Foggy - 21 / 17",
                    "Weds - Cloudy - 22 / 20",
                    "Thurs - Rainy - 20 / 15",
                    "Fri - Foggy - 24 / 22",
                    "Sat - Sunny - 30 / 26",
                    "Sun - Sunny - 35 / 29"
            };

            //then we transform the array into an ArrayList
            ArrayList<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray)
            );


            //we initialize the ArrayAdapter
            mForecastAdapter = new ArrayAdapter<String>(
                    //the current context (this fragment)
                    getActivity(),
                    //ID of list item layout
                    R.layout.list_item_forecast,
                    //ID of the textview to populate
                    R.id.list_item_forecast_textview,
                    //Forecast data (ArrayList)
                    weekForecast
            );

            //Let's go through the fragment_main.xml file and search for the ListView with
            // id listview_forecast
            ListView myListView = (ListView) rootView.findViewById(
                    R.id.listview_forecast
            );

            //Set the adapter to the ListView
            myListView.setAdapter(mForecastAdapter);


            return rootView;
        }
    }
}

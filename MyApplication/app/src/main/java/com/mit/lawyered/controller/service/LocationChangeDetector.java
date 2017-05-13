package com.mit.lawyered.controller.service;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ahmed on 5/13/2017.
 */

public class LocationChangeDetector extends Service {
    LocationManager locationManager;
    LocationListener locationListener;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        super.onCreate();

        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
        Log.w("s","done");
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.w("chnnge","location");
                Toast.makeText(getApplicationContext(),"Location Changed",Toast.LENGTH_SHORT).show();
                new RequestTask().execute(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.w("Status","changed");
            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }

        };
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED||
                ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
            Toast.makeText(getApplicationContext(),"registered",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"register failed",Toast.LENGTH_SHORT).show();
        }
    }

    public void onDestroy(){
        Log.w("service","dis");
        Toast.makeText(getApplicationContext()," destro",Toast.LENGTH_SHORT).show();
    }

    public List<String> getTypesList(JSONObject jsonObject){
        List<String> typesArray = new ArrayList<>();
        try{
            JSONArray placesArray = jsonObject.getJSONArray("results");
            for(int i=0;i<placesArray.length();i++){
                JSONObject place = placesArray.getJSONObject(i);
                JSONArray types = place.getJSONArray("types");
                for(int j=0;j<types.length();j++){
                    if(!typesArray.contains(types.get(j)))
                        typesArray.add(types.get(j).toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return typesArray;
    }

    class RequestTask extends AsyncTask<Location,Void,JSONObject> {

        @Override
        protected JSONObject doInBackground(Location... params) {

            //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=6.9351353,79.8609322&radius=50&key=%20AIzaSyATUMNVGi6cVgfdBcpoWSHxm0h8r6L9BW0
            String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+params[0].getLatitude()+","+params[0].getLongitude()+"&radius=50&key=%20AIzaSyATUMNVGi6cVgfdBcpoWSHxm0h8r6L9BW0";
            getPlaceJSON(url);
            return  getPlaceJSON(url);
        }

        protected void onPostExecute(JSONObject jsonObject){
            //Toast.makeText(getApplicationContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();
            List<String> types = getTypesList(jsonObject);
            String oneLine ="";
            for(String type :types){
                oneLine+=type+" : ";
            }
            Toast.makeText(getApplicationContext(),oneLine,Toast.LENGTH_SHORT).show();
        }


        public JSONObject getPlaceJSON(String urlString){
            InputStream inputStream;
            String result="";
            JSONObject jsonObject = null;
            HttpURLConnection httpURLConnection;
            try{
                URL url = new URL(urlString);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                inputStream = httpURLConnection.getInputStream();

                if(inputStream!=null){
                    result = convertInputStreamToString(inputStream);
                    return new JSONObject(result);
                }
            }catch(MalformedURLException ex){
                Log.w("Error",ex.getMessage());
            }catch (IOException ex){
                Log.w("Error",ex.getMessage());
            }catch (JSONException ex){
                Log.w("Error",ex.getMessage());
            }

            return jsonObject;
        }


        private String convertInputStreamToString(InputStream inputStream) throws IOException{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine())!= null){
                result += line;
            }
            inputStream.close();
            return result;
        }


    }
}

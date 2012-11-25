package com.nrcan.controllers;

import android.location.LocationProvider;
import android.location.LocationManager;
import android.location.Location;
import android.location.GpsStatus;
import android.location.GpsSatellite;
import android.location.Criteria;
import android.location.LocationListener;
import android.content.Context;
import android.text.format.Time;
import android.text.format.DateFormat;
import android.os.Bundle;
import java.util.Calendar;
import java.util.Iterator;

public class GPSController {
    
    private Context context;
    private volatile int numberOfSatellites;
    private double elevation;
    private double longitude;
    private double latitude;
    private String provider;
    private LocationManager locationManager;
    private GPSLocationListener locationListener;
    private GPSStatusListener gpsStatusListener;

    public GPSController(Context context) {
        this.context = context;
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    }

    public void turnOnGPS() {

        locationListener = new GPSLocationListener();
        gpsStatusListener = new GPSStatusListener();

        Criteria criteria = new Criteria();

        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);

        provider = locationManager.getBestProvider(criteria, true);

        System.out.println("the gps provider = " + provider);

        locationManager.addGpsStatusListener(gpsStatusListener);
        locationManager.requestLocationUpdates(provider, 1000, 0, locationListener);
    }

    public void turnOffGPS() {
        
        locationManager.removeGpsStatusListener(gpsStatusListener);
        locationManager.removeUpdates(locationListener);
    }

    public void requestGPSData() {
        Location location = locationManager.getLastKnownLocation(provider);

        if(location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            elevation = location.getAltitude();

            // Print all the values
            System.out.println("latitude = " + latitude);
            System.out.println("longitude = " + longitude);
            System.out.println("elevation = " + elevation);
            System.out.println("numSatellites = " + numberOfSatellites);
        }
    }

    public int getNumberOfSatellites() {
        return numberOfSatellites; 
    }

    public double getElevation() {
        return elevation;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getProvider() {
        return provider;
    }

    // Listener class
    private class GPSLocationListener implements LocationListener {

        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            elevation = location.getAltitude();

            System.out.println("inside onlocchanged");
            System.out.println("lat = " + latitude);
            System.out.println("long = " + longitude);
            System.out.println("elevation = " + elevation);
        }

        public void onProviderDisabled(String provider) { }
        public void onProviderEnabled(String provider) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }
    }

    public class GPSStatusListener implements GpsStatus.Listener {

        public void onGpsStatusChanged(int event) {
        /*    GpsStatus gpsStatus = locationManager.getGpsStatus(null);

            if(gpsStatus != null) {
                
                Iterator<GpsSatellite> satellite = gpsStatus.getSatellites().iterator();
                
                while(satellite.hasNext()) {
                    numberOfSatellites++;
                }
            }*/
        }
    }
}

package com.tecknowwizards.currentlocationapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private GpsTracker gpsTracker;
    double lat = -34;
    double lng = 151;
    double log = 0;
    double shop1[]={0.0,0.0};
    double shop2[]={0.0,0.0};
    double shop3[]={0.0,0.0};
    double shop4[]={0.0,0.0};
    double shop5[]={0.0,0.0};
    double shop6[]={0.0,0.0};
    double shop7[]={0.0,0.0};
    double shop8[]={0.0,0.0};
    double shop9[]={0.0,0.0};
    double shop10[]={0.0,0.0};
    double shop11[]={0.0,0.0};
    double shop12[]={0.0,0.0};
    double shop13[]={0.0,0.0};
    double shop14[]={0.0,0.0};
    double shop15[]={0.0,0.0};
    double shop16[]={0.0,0.0};
    double shop17[]={0.0,0.0};
    double shop18[]={0.0,0.0};
    double shop19[]={0.0,0.0};
    double shop20[]={0.0,0.0};
    double allshopes[][]={shop1,shop2,shop3,shop4,shop5,shop6,shop7,shop8,shop9,shop10,shop11,shop12,shop13,shop14,shop15,shop16,shop17,shop18,shop19,shop20};
    double all[];





    private static final String TAG = "myapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gpsTracker = new GpsTracker(MapsActivity.this);
        if(gpsTracker.canGetLocation()){
            lat = gpsTracker.getLatitude();
            lng = gpsTracker.getLongitude();
            Log.d(TAG,"gps_tracker");
            Log.d(TAG, "lat is: " + lat);
            Log.d(TAG, "lng is: " + lng);
        }else{
            gpsTracker.showSettingsAlert();
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        all = extras.getDoubleArray("key");
        double lt = extras.getDouble("lat");
        double ln = extras.getDouble("lng");
        for(int i=0;i<20;i++){
            Log.d(TAG, "val: " + all[i]);
        }
       /* for(int i=0;i<20;i++){
            LatLng loc = new LatLng(all[i], all[i+1]);
            mMap.addMarker(new MarkerOptions().position(loc).title("Marker in Sydney"));
            i++;
        }*/



        mMap = googleMap;
        LatLng sydney = new LatLng(all[0], all[1]);
        LatLng place1 = new LatLng(all[2],all[3]);
        LatLng place2 = new LatLng(all[4],all[5]);
        LatLng place3 = new LatLng(all[6],all[7]);
        LatLng place4 = new LatLng(all[8],all[9]);
        LatLng place5 = new LatLng(all[10],all[11]);
        LatLng place6 = new LatLng(all[12],all[13]);
        LatLng place7 = new LatLng(all[14],all[15]);
        LatLng place8 = new LatLng(all[16],all[16]);
        LatLng place9 = new LatLng(all[18],all[19]);

        //Toast.makeText(MapsActivity.this,"lng"+all[0], Toast.LENGTH_SHORT).show();
        //Toast.makeText(MapsActivity.this,"lat"+all[1], Toast.LENGTH_SHORT).show();
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(place1).title("Marker in place1"));
        mMap.addMarker(new MarkerOptions().position(place2).title("Marker in place2"));
        mMap.addMarker(new MarkerOptions().position(place3).title("Marker in place3"));
        mMap.addMarker(new MarkerOptions().position(place4).title("Marker in place4"));
        mMap.addMarker(new MarkerOptions().position(place5).title("Marker in place5"));
        mMap.addMarker(new MarkerOptions().position(place6).title("Marker in place6"));
        mMap.addMarker(new MarkerOptions().position(place7).title("Marker in place7"));
        mMap.addMarker(new MarkerOptions().position(place8).title("Marker in place8"));
        mMap.addMarker(new MarkerOptions().position(place9).title("Marker in place9"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    }
    public void Write_Variables(double lat,double lng, int id){
        allshopes[id][0]=lat;
        allshopes[id][1]=lng;

    }
}
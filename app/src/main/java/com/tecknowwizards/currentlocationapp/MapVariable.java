package com.tecknowwizards.currentlocationapp;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MapVariable {

    private final Context mContext;
    private static final String TAG = "myapp";
    double lat0,lng0 =0;
    double lat1,lng1 =0;
    double lat2,lng2 =0;
    double lat3,lng3 =0;
    double lat4,lng4 =0;
    double lat5,lng5 =0;
    double lat6,lng6 =0;
    double lat7,lng7 =0;
    double lat8,lng8 =0;
    double lat9,lng9 =0;
    double lat10,lng10 =0;
    double lat11,lng11 =0;
    double lat12,lng12 =0;
    double lat13,lng13 =0;
    double lat14,lng14 =0;
    double lat15,lng15 =0;
    double lat16,lng16 =0;
    double lat17,lng17 =0;
    double lat18,lng18 =0;
    double lat19,lng19 =0;
    double latlng[][]={{lat0,lat1,lat2,lat3,lat4,lat5,lat6,lat7,lat8,lat9,lat10,lat11,lat12,lat13,lat14,lat15,lat16,lat17,lat18,lat19},
            {lng0,lng1,lng2,lng3,lng4,lng5,lng6,lng7,lng8,lng9,lng10,lng11,lng12,lng13,lng14,lng15,lng16,lng17,lng18,lng19}};



    public MapVariable(Context mContext) {
        this.mContext = mContext;
        update_values();
    }

    private void update_values() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("location");
        myRef.child("latitude").setValue(latlng);
        myRef.child("longitude").setValue(latlng);

        Log.d(TAG, "Value1 is: " + latlng);
        Log.d(TAG, "Value2 is: " + latlng);
    }
}

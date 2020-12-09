package com.tecknowwizards.currentlocationapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    Button btn;
    private static final String TAG = "myapp";

    MapsActivity MapsActivity;

    double lat1 = 0,log1 = 0;
    double lat2 = 0,log2 = 0;
    double lat3 = 0,log3 = 0;
    double lat4 = 0,log4 = 0;
    double lat5 = 0,log5 = 0;
    double lat6 = 0,log6 = 0;
    double lat7 = 0,log7 = 0;
    double lat8 = 0,log8 = 0;
    double lat9 = 0,log9 = 0;
    double lat10 = 0,log10 = 0;
    double Total=0;
    //Toast.makeText(MainActivity.this,"network error try again"+lat1, Toast.LENGTH_LONG).show();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.bt_submit);
        String location ="location";
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(location);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lat1 = dataSnapshot.child("1").getValue(double.class);
                log1 = dataSnapshot.child("2").getValue(double.class);
                lat2 = dataSnapshot.child("3").getValue(double.class);
                log2 = dataSnapshot.child("4").getValue(double.class);
                lat3 = dataSnapshot.child("5").getValue(double.class);
                log3 = dataSnapshot.child("6").getValue(double.class);
                lat4 = dataSnapshot.child("7").getValue(double.class);
                log4 = dataSnapshot.child("8").getValue(double.class);
                lat5 = dataSnapshot.child("9").getValue(double.class);
                log5 = dataSnapshot.child("10").getValue(double.class);
                lat6 = dataSnapshot.child("11").getValue(double.class);
                log6 = dataSnapshot.child("12").getValue(double.class);
                lat7 = dataSnapshot.child("13").getValue(double.class);
                log7 = dataSnapshot.child("14").getValue(double.class);
                lat8 = dataSnapshot.child("15").getValue(double.class);
                log8 = dataSnapshot.child("16").getValue(double.class);
                lat9 = dataSnapshot.child("17").getValue(double.class);
                log9 = dataSnapshot.child("18").getValue(double.class);
                lat10 = dataSnapshot.child("lat").getValue(double.class);
                log10 = dataSnapshot.child("lng").getValue(double.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(lat1*log1 != 0){
                    //MapsActivity.Write_Variables(lat1,log1,1);
                    Total++;
                }
                if(lat2*log2 != 0){
                    //MapsActivity.Write_Variables(lat2,log2,2);
                    Total++;
                }
                if(lat3*log3 != 0){
                   // MapsActivity.Write_Variables(lat3,log3,3);
                    Total++;
                }
                if(lat4*log4 != 0){
                   // MapsActivity.Write_Variables(lat4,log4,4);
                    Total++;
                }
                if(lat5*log5 != 0){
                    //MapsActivity.Write_Variables(lat5,log5,5);
                    Total++;
                }
                if(lat6*log6 != 0){
                    //MapsActivity.Write_Variables(lat6,log6,6);
                    Total++;
                }
                if(lat7*log7 != 0){
                    //MapsActivity.Write_Variables(lat7,log7,7);
                    Total++;
                }
                if(lat8*log8 != 0){
                    //MapsActivity.Write_Variables(lat8,log8,8);
                    Total++;
                }
                if(lat9*log9 != 0){
                    //MapsActivity.Write_Variables(lat9,log9,9);
                    Total++;
                }
                if(lat10*log10 != 0){
                    //MapsActivity.Write_Variables(lat10,log10,10);
                    Total++;
                }
                if(Total>9){
                    double all[]={lat1,log1,lat2,log2,lat3,log3,lat4,log4,lat5,log5,lat6,log6,lat7,log7,lat8,log8,lat9,log9,lat10,log10};
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    Bundle extras = new Bundle();
                    extras.putDoubleArray("key",all);
                    extras.putDouble("lat",13);
                    extras.putDouble("lng",151);
                    intent.putExtras(extras);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"opening map", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this,"network error try again"+Total, Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
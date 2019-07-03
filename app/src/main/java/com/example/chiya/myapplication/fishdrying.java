package com.example.chiya.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fishdrying extends AppCompatActivity {
    Button button7;
    public TextView sensors;
    public TextView sensors2;
    public EditText editTemp;
    public EditText editHumid;
    private static final String TAG = "MainActivity";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Commands");

   // final DatabaseReference myRef2 = database.getReference("TempHumid");
    //final DatabaseReference myRef3 = database.getReference("Humidity");
    //DatabaseReference read = myRef2.child("Temperature");
    //DatabaseReference read2 = myRef2.child("Humidity");

    //ValueEventListener eventListener = new ValueEventListener();


    // methods for reading and visualisation in the comments to be continued......

   /* public  void onStart(){
        super.onStart();

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               // for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                   String Temperature = dataSnapshot.getValue(String.class);
                   String Humidity=dataSnapshot.getValue(String.class);
                  // String Humidity=snapshot.child("Humidity").getValue(String.class);
                   //String Humidity=snapshot.child("Humidity").getValue(String.class);
                   sensors.setText(Temperature);
                   sensors2.setText(Humidity);
                   // Log.d(TAG,"value is:" + Temperature() +"" + Humidity);
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    /*  public void onStart() {
        super.onStart();
        myRef2.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange (@NonNull DataSnapshot dataSnapshot){
            Double temperature = dataSnapshot.getValue(Double.class);
            String temp = String.valueOf(temperature);
            sensors.setText(temp);
            Log.d(TAG, "Value is: " + temperature);
        }

        @Override
        public void onCancelled (@NonNull DatabaseError error){
            Log.w(TAG, "Failed to read value.", error.toException());

        }
    });
        myRef3.addValueEventListener(new

    ValueEventListener() {
        @Override
        public void onDataChange (@NonNull DataSnapshot dataSnapshot){
            Double humidity = dataSnapshot.getValue(Double.class);
            String humi = String.valueOf(humidity);
            sensors2.setText(humi);
            Log.d(TAG, "Value is: " + humidity);
        }

        @Override
        public void onCancelled (@NonNull DatabaseError error){
            Log.w(TAG, "Failed to read value.", error.toException());
        }
    });

}*/

   /* public void onStart() {
        super.onStart();

           // public void onDataChange(DataSnapshot dataSnapshot) {
             //  for (DataSnapshot ds : dataSnapshot.getChildren()) {
                   Integer Temperature = ds.child("Temperature").getValue(Integer.class);
                   Integer Humidity = ds.child("Humidity").getValue(Integer.class);

                   // Log.d(TAG, Temperature + " / " + Humidity);
                   //assert sensors != null;
                   String hum = String.valueOf(Humidity);
                   String tem = String.valueOf(Temperature);
                   sensors.setText(tem);
                   sensors2.setText(hum);

               }
                }

            public void onCancelled(DatabaseError databaserror) {

                   // Log.w(TAG, "Failed to read value.", error.toException());
                }



    }
*/

   //method to write to firebase to stop drying
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishdrying);
        button7 = findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInstance();

                startActivity(new Intent(fishdrying.this, fishstopped.class));
            }

            public void getInstance()
            {
                myRef.setValue(0);

            }
        });





    }




    }





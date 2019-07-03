package com.example.chiya.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fish extends AppCompatActivity {
        Button fsbutton,gobutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Commands");



        fsbutton = findViewById(R.id.fsbutton);
        fsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInstance();
                startActivity(new Intent(fish.this,fishdrying.class));
            }
                public void getInstance() {
                    myRef.setValue(2);



        }

       });
      //  public void buttonClick(View view) {

        gobutton=findViewById(R.id.gobutton);
        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fish.this, first.class));

            }



        });


    }
}


package com.example.chiya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class veg extends AppCompatActivity {
    Button vsbutton,gobutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Commands");
        vsbutton=findViewById(R.id.vsbutton);
        //start drying after onclick
        vsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInstance();
                startActivity(new Intent(veg.this,vegdrying.class));
            }

            public void getInstance() {
                myRef.setValue(1);
            }

        });
        gobutton3=findViewById(R.id.gobutton3);
        gobutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(veg.this,first.class));
            }
        });


        };
}

package com.example.chiya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fruit extends AppCompatActivity {
    Button gobutton1,fsbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Commands");
        fsbutton1=findViewById(R.id.fsbutton1);
        //start drying after onclick
        fsbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInstance();
                startActivity(new Intent(fruit.this,fruitdrying.class));
            }

            public void getInstance() {
                myRef.setValue(1);
            }
            
    });
    gobutton1=findViewById(R.id.gobutton1);
        //start drying after onclick
        gobutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                       startActivity(new Intent(fruit.this,first.class));
            }
});
    }}
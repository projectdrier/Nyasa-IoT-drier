package com.example.chiya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class meat extends AppCompatActivity {
    Button msbutton,gobutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Commands");
        msbutton=findViewById(R.id.msbutton);
        msbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInstance();
                startActivity(new Intent(meat.this,meatdrying.class));
            }
            public void getInstance(){
                myRef.setValue(2);
            }
        });
        gobutton2=findViewById(R.id.gobutton2);
        gobutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(meat.this,first.class));
            }
        });
    }
}

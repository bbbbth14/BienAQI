package com.example.bienaqi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView temp;
    TextView humid;
    TextView pm10;
    TextView pm25;
    TextView AQI;
    ImageButton bt1;
    ImageButton bt2;
    ImageButton bt3;
    ImageButton bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = findViewById(R.id.temp_fb);
        humid = findViewById(R.id.HUMID_FB);
        pm10 = findViewById(R.id.PM10_FB);
        pm25 = findViewById(R.id.PM2_5_FB);
        AQI = findViewById(R.id.AQI_FB);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt3=findViewById(R.id.bt3);
        bt4=findViewById(R.id.bt4);
        DatabaseReference temp_fb = FirebaseDatabase.getInstance().getReference("Temp_fb");
        DatabaseReference humid_fb = FirebaseDatabase.getInstance().getReference("Humid_fb");
        DatabaseReference PM10_fb = FirebaseDatabase.getInstance().getReference("PM10_fb");
        DatabaseReference PM25_fb = FirebaseDatabase.getInstance().getReference("PM25_fb");
        DatabaseReference AQI_fb = FirebaseDatabase.getInstance().getReference("AQI_fb");
        DatabaseReference bt1_fb = FirebaseDatabase.getInstance().getReference("ON1");
        DatabaseReference bt2_fb = FirebaseDatabase.getInstance().getReference("ON2");
        // Temperature
        temp_fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                temp.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {


            }
        });

        //Humidity
        humid_fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                humid.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

        //PM10
        PM10_fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pm10.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
        //PM2.5
        PM25_fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pm25.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

        //AQI
        AQI_fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                AQI.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1_fb.setValue(1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1_fb.setValue(0);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt2_fb.setValue(1);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt2_fb.setValue(0);
            }
        });





    }
}
package com.example.medisyncxperience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welocome "+username, Toast.LENGTH_SHORT).show();

        //Exit Card
        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity2.this,LoginActivity2.class);
                startActivity(it);
            }
        });
        //Find Doctor
        CardView findDoc = findViewById(R.id.cardFindDoctor);
        findDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity2.this,FindDoctorActivity.class));
            }
        });
        CardView LabTest = findViewById(R.id.cardLabTest);
        LabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity2.this,LabTestActivity.class));
            }
        });
        CardView History = findViewById(R.id.cardMedicalHistory);
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity2.this,MedicalHistoryActivity.class));
            }
        });
    }
}
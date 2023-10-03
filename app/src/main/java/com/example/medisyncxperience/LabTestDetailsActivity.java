package com.example.medisyncxperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnAddTC, btnLDBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.EditTextLDMultiline);
        btnLDBack = findViewById(R.id.buttonLDBack);
        btnAddTC = findViewById(R.id.buttonToCart);

        edDetails.setKeyListener(null);
        Intent it = getIntent();
        String packageName = it.getStringExtra("text1");
        String totalCost = it.getStringExtra("text2");
        float price = Float.parseFloat(it.getStringExtra("text3"));

        tvPackageName.setText(it.getStringExtra("text1"));
        tvTotalCost.setText("Total Cost: " + it.getStringExtra("text3")+"/-");
        edDetails.setText(it.getStringExtra("text2"));

        btnLDBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnAddTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                Database db = new Database(LabTestDetailsActivity.this);

                if (db.checkCart(username, packageName) == 0) {
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addToCart(username, packageName, price, "lab");
                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}

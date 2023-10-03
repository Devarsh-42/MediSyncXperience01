package com.example.medisyncxperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1: Full Body Test", "","","", "Price: 2000"},
            {"Package 2: Blood Test", "","","", "Price: 800"},
            {"Package 3: COVID-19 Test", "","","", "Price: 700"},
            {"Package 4: Immunity Test", "","","", "Price: 900"},
            {"Package 5: Thyroid Test", "","","", "Price: 600"},
    };
    private String[] packages_details = {
        "Blood Glucose Fasting\n" +
            "Complete Hemogram\n" +
                    "HbA1c\n" +
            "Iron Studies\n" +
            "Kidney Function Testin"+
        "LDH Lactate Dehydrogenase, Serum\n" +
                "Lipid Profile\n" +
                "Liver Function Test",// 1
            "Blood Glucose Fasting",// 2
                "COVID-19 Antibody - IgG",// 3
                "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",// 4
        "Complete Hemogram\n" +
                "CRP (C Reactive Protein) Quantitative, Serum\n" +
                "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid Profile"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnTOCart,btnBAck;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnTOCart = findViewById(R.id.buttonToCart);
        btnBAck = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.textViewLD);

        btnBAck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity2.class));
            }
        });
        btnTOCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, LabTestDetailsActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("Line5","Cons. Fees: " + packages[i][4] + " Rs.");
            list.add( item );
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}
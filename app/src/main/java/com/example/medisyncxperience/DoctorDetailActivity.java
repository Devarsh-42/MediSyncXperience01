package com.example.medisyncxperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    private final String[][] doctordetail1 =
            {
                    {"Doctor Name: Dr. Devarsh Mehta", "Address: Sector 12, Gandhinagar","Exp: 5yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr. Charvit Zalavadya", "Address: Sector 24, Gandhinagar","Exp: 6yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr Jenil Kakadiya", "Address: Sector 19, Gandhinagar","Exp: 3yrs", " Mobile No:988765431", "Price: 700"},
                    {"Doctor Name: Dr Krishn Patel", "Address: Sector 22, Gandhinagar","Exp: 8yrs", " Mobile No:938765491", "Price: 800"},
                    {"Doctor Name: Dr Meera Prajapati", "Address: Kudasan, Gandhinagar","Exp: 6yrs", " Mobile No:928765431", "Price: 900"},
                    {"Doctor Name: Dr Aliya Topiwala", "Address: Sector 7,Gandhinagar","Exp: 3yrs", "Mobile No:918765431", "Price: 950"}
            };
    private final String[][] doctordetail2 =
            {
                    {"Doctor Name: Dr. Devarsh Mehta", "Address: Sector 12, Gandhinagar","Exp: 5yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr. Charvit Zalavadya", "Address: Sector 24, Gandhinagar","Exp: 6yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr Jenil Kakadiya", "Address: Sector 19, Gandhinagar","Exp: 3yrs", " Mobile No:988765431", "Price: 700"},
                    {"Doctor Name: Dr Krishn Patel", "Address: Sector 22, Gandhinagar","Exp: 8yrs", " Mobile No:938765491", "Price: 800"},
                    {"Doctor Name: Dr Meera Prajapati", "Address: Kudasan, Gandhinagar","Exp: 6yrs", " Mobile No:928765431", "Price: 900"},
                    {"Doctor Name: Dr Aliya Topiwala", "Address: Sector 7,Gandhinagar","Exp: 3yrs", "Mobile No:918765431", "Price: 950"}
            };
    private final String[][] doctordetail3 =
            {
                    {"Doctor Name: Dr. Devarsh Mehta", "Address: Sector 12, Gandhinagar","Exp: 5yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr. Charvit Zalavadya", "Address: Sector 24, Gandhinagar","Exp: 6yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr Jenil Kakadiya", "Address: Sector 19, Gandhinagar","Exp: 3yrs", " Mobile No:988765431", "Price: 700"},
                    {"Doctor Name: Dr Krishn Patel", "Address: Sector 22, Gandhinagar","Exp: 8yrs", " Mobile No:938765491", "Price: 800"},
                    {"Doctor Name: Dr Meera Prajapati", "Address: Kudasan, Gandhinagar","Exp: 6yrs", " Mobile No:928765431", "Price: 900"},
                    {"Doctor Name: Dr Aliya Topiwala", "Address: Sector 7,Gandhinagar","Exp: 3yrs", "Mobile No:918765431", "Price: 950"}
            };
    private final String[][] doctordetail4 =
            {
                    {"Doctor Name: Dr. Devarsh Mehta", "Address: Sector 12, Gandhinagar","Exp: 5yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr. Charvit Zalavadya", "Address: Sector 24, Gandhinagar","Exp: 6yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr Jenil Kakadiya", "Address: Sector 19, Gandhinagar","Exp: 3yrs", " Mobile No:988765431", "Price: 700"},
                    {"Doctor Name: Dr Krishn Patel", "Address: Sector 22, Gandhinagar","Exp: 8yrs", " Mobile No:938765491", "Price: 800"},
                    {"Doctor Name: Dr Meera Prajapati", "Address: Kudasan, Gandhinagar","Exp: 6yrs", " Mobile No:928765431", "Price: 900"},
                    {"Doctor Name: Dr Aliya Topiwala", "Address: Sector 7,Gandhinagar","Exp: 3yrs", "Mobile No:918765431", "Price: 950"}
            };
    private String[][] doctordetail5 =
            {
                    {"Doctor Name: Dr. Devarsh Mehta", "Address: Sector 12, Gandhinagar","Exp: 5yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr. Charvit Zalavadya", "Address: Sector 24, Gandhinagar","Exp: 6yrs"," Mobile No:948905431", "Price: 600"},
                    {"Doctor Name: Dr Jenil Kakadiya", "Address: Sector 19, Gandhinagar","Exp: 3yrs", " Mobile No:988765431", "Price: 700"},
                    {"Doctor Name: Dr Krishn Patel", "Address: Sector 22, Gandhinagar","Exp: 8yrs", " Mobile No:938765491", "Price: 800"},
                    {"Doctor Name: Dr Meera Prajapati", "Address: Kudasan, Gandhinagar","Exp: 6yrs", " Mobile No:928765431", "Price: 900"},
                    {"Doctor Name: Dr Aliya Topiwala", "Address: Sector 7,Gandhinagar","Exp: 3yrs", "Mobile No:918765431", "Price: 950"}
            };
    TextView tv;
    Button btn;
    ArrayList List;
    SimpleAdapter sa;
    HashMap<String, String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv = findViewById(R.id.textViewLabLocation);
        btn = findViewById(R.id.buttonLTBack);
        String[][] Doctor_detail = {};
//
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        if (title.compareTo("Family Physician") == 0)
            Doctor_detail = doctordetail1;
        else
        if (title.compareTo("Dietitian") == 0)
            Doctor_detail = doctordetail2;
        else
        if (title.compareTo("Cardiologist") == 0)
            Doctor_detail = doctordetail3;
        else
        if (title.compareTo("Dentist") == 0)
            Doctor_detail = doctordetail4;
        else
            Doctor_detail = doctordetail5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailActivity.this, FindDoctorActivity.class));
            }
        });
        List = new ArrayList();
        for (int i=0; i<Doctor_detail.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", Doctor_detail[i][0]);
            item.put("line2", Doctor_detail[i][1]);
            item.put("line3", Doctor_detail[i][2]);
            item.put("line4", Doctor_detail[i][3]);
            item.put("Line5","Cons. Fees: " + Doctor_detail[i][4] + " Rs.");
            List.add( item );
        }
        sa = new SimpleAdapter(this, List,
                R.layout.multi_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.textViewLD);
        lst.setAdapter(sa);

        String[][] finalDoctor_detail = Doctor_detail;
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2", finalDoctor_detail[i][0]);
                it.putExtra("text3", finalDoctor_detail[i][1]);
                it.putExtra("text4", finalDoctor_detail[i][3]);//Exp in not required hence 2 Skip.
                it.putExtra("text5", finalDoctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}
package com.example.medisyncxperience;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MedicalHistoryActivity extends AppCompatActivity {

    TextView tvUsername, tvBloodGroup;
    EditText edRecentDiseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);

        // Initialize views
        tvUsername = findViewById(R.id.editTextAppFullName);
        tvBloodGroup = findViewById(R.id.editTextAppBloodGroup);
        edRecentDiseases = findViewById(R.id.editTextAppMedHistory);

        // Retrieve user data from the database and set it to the respective views
        Database db = new Database(this);

        // Replace "your_username" with the actual username of the logged-in user
        String username = "your_username";

        // Fetch user data (including blood group and recent diseases) from the database
        UserData userData = db.getUserData(username);

        if (userData != null) {
            tvUsername.setText("Username: " + userData.getUsername());
            tvBloodGroup.setText("Blood Group: " + userData.getBloodGroup());
            edRecentDiseases.setText(userData.getRecentDiseases());
        }
    }
}

class UserData {
    private String username;
    private String bloodGroup;
    private String recentDiseases;

    public UserData(String username, String bloodGroup, String recentDiseases) {
        this.username = username;
        this.bloodGroup = bloodGroup;
        this.recentDiseases = recentDiseases;
    }

    public String getUsername() {
        return username;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getRecentDiseases() {
        return recentDiseases;
    }
}

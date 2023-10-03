package com.example.medisyncxperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewUserActivity2 extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirmPassword, edBloodGroup, edRecentDiseases;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user2);

        edUsername = findViewById(R.id.editTextAppFullName);
        edEmail = findViewById(R.id.editTextAppAddress);
        edPassword = findViewById(R.id.editTextRegAppContactNo);
        edConfirmPassword = findViewById(R.id.editTextRegAppFees);
        edBloodGroup = findViewById(R.id.editTextAppBloodGroup);
        edRecentDiseases = findViewById(R.id.editTextAppMedHistory);
        btn = findViewById(R.id.buttonBookApp);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewUserActivity2.this, LoginActivity2.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirmPassword.getText().toString();
                Database sdb = new Database(NewUserActivity2.this); // Initialize the Database class

                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Fill the Given Details!", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirm)) {
                        if (isValid(password)) {
                            sdb.register(username, email, password);
                            Toast.makeText(getApplicationContext(),"Registration Successful!!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(NewUserActivity2.this, LoginActivity2.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, a letter, digits, and a special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String password) {
        // Implement your password validation logic here
        // Password must contain at least 8 characters, a letter, digits, and a special symbol
        return true; // Placeholder for validation logic.
    }
}

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

public class LoginActivity2 extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database sdb = new Database(LoginActivity2.this); // Initialize the Database class

                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(LoginActivity2.this, "Please Fill in Both Fields", Toast.LENGTH_SHORT).show();
                } else {
                    int loginResult = sdb.login(username, password);

                    if (loginResult == 1) {
                        Toast.makeText(LoginActivity2.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        // Store user data securely or manage user sessions here
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.apply();

                        startActivity(new Intent(LoginActivity2.this, HomeActivity2.class));
                    } else {
                        Toast.makeText(LoginActivity2.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity2.this, NewUserActivity2.class));
            }
        });
    }
}

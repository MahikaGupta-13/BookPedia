package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
Button bttn;
TextView tv;
EditText edUsername, edEmail, edPassword, edContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        bttn = findViewById(R.id.btnReg);
        edUsername = findViewById(R.id.edtuname);
        edEmail = findViewById(R.id.edtuemail);
        edPassword = findViewById(R.id.edtupass);
        edContact = findViewById(R.id.edtucon);
        tv=findViewById(R.id.txtgetlog);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String contact = edContact.getText().toString();
                Database db = new Database(getApplicationContext(), "books", null, 1);
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || contact.length() == 0) {
                    Toast.makeText(RegActivity.this, "Please fill all details...", Toast.LENGTH_SHORT).show();
                } else {
                        if (isValid(password)) {
                            db.register(username,email,password,contact);
                            Toast.makeText(RegActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(RegActivity.this, "Password must contain at least 8 characters, having letters, digits and symbols", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c > 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1) {
                return true;
            }
            return false;
        }
    }
}
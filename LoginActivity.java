package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button btn;
TextView tv;
EditText edUsername, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv=findViewById(R.id.txtReg);
        edUsername=findViewById(R.id.edtunm);
        edPassword=findViewById(R.id.edtupss);
        btn=findViewById(R.id.btnLogin);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "books",null,1);
                if(username.length() == 0 || password.length() == 0){
                    Toast.makeText(LoginActivity.this, "Please fill all fields...", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (db.login(username, password) == 1){
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        //startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                        startActivity(new Intent(LoginActivity.this,HomePage1Activity.class));
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePage1Activity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);
        ImageView fav,later,read,done;
        fav=findViewById(R.id.viewfav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage1Activity.this, ViewFav.class));
            }
        });
        later=findViewById(R.id.viewLater);
        later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage1Activity.this, HMPGActivity.class));
            }
        });
        read=findViewById(R.id.readBooks);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage1Activity.this, HMPGActivity.class));
            }
        });
        done=findViewById(R.id.viewRead);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage1Activity.this, HMPGActivity.class));
            }
        });
    }
}
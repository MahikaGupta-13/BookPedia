package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HMPGActivity extends AppCompatActivity {
    ImageView fictional,nonfictional,business,motivational,poem,biographies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hmpgactivity);

        fictional=findViewById(R.id.fic1);
        nonfictional=findViewById(R.id.nonfic1);
        business=findViewById(R.id.business1);
        motivational=findViewById(R.id.moti1);
        poem=findViewById(R.id.poems1);
        biographies=findViewById(R.id.bio1);

        fictional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fc=new Intent(HMPGActivity.this,SeeBooks.class);
                fc.putExtra("title","Fictional");
                startActivity(fc);
            }
        });
        nonfictional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nfc=new Intent(HMPGActivity.this,SeeBooks.class);
                nfc.putExtra("title","Non-Fictional");
                startActivity(nfc);
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bus=new Intent(HMPGActivity.this,SeeBooks.class);
                bus.putExtra("title","Business");
                startActivity(bus);
            }
        });
        motivational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mot=new Intent(HMPGActivity.this,SeeBooks.class);
                mot.putExtra("title","Motivational");
                startActivity(mot);
            }
        });
        biographies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bio=new Intent(HMPGActivity.this,SeeBooks.class);
                bio.putExtra("title","Biographies");
                startActivity(bio);
            }
        });
        poem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pe=new Intent(HMPGActivity.this,SeeBooks.class);
                pe.putExtra("title","Poem");
                startActivity(pe);
            }
        });

    }
}
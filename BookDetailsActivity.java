package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailsActivity extends AppCompatActivity {
    TextView tv1;
    EditText edDetails;
    ImageButton read, fav;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        tv1 = findViewById(R.id.BookName);
        edDetails = findViewById(R.id.edBookDetails);
        edDetails.setKeyListener(null);
        read = findViewById(R.id.btnRead);
        fav = findViewById(R.id.btnFav);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        String url = intent.getStringExtra("text3");

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(BookDetailsActivity.this, ViewPdfActivity.class);
                it.putExtra("text1", url);
                startActivity(it);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String bookname = tv1.getText().toString();

                Database db = new Database(getApplicationContext(), "books",null,1);
                if (db.checkFav(username,bookname) == 1){
                    Toast.makeText(BookDetailsActivity.this, "Book Already Exists...", Toast.LENGTH_SHORT).show();
                }

                else{
                    db.addFav(username,bookname);
                    Toast.makeText(BookDetailsActivity.this, "Book added to favourite", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(BookDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}
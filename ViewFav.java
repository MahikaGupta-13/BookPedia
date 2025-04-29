package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewFav extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    private String[] packages = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fav);


        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Database db = new Database(getApplicationContext(), "books", null, 1);
        ArrayList dbData = db.getFavData(username);

        packages = new String[dbData.size()];





        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i]);
            item.put("line2", packages[i]);
            item.put("line3", packages[i]);
            item.put("line4", packages[i]);
            item.put("line5", packages[i]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d,R.id.line_e }
        );

        ListView lst = findViewById(R.id.listViewBM);
        lst.setAdapter(sa);
    }
}
package com.example.bookpediaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class SeeBooks extends AppCompatActivity {


    private String[][] poems =
            {
                    {"Your Soul Is a River", "Nikita Gill", "4.5", "", "Click for more Details"},
                    {"Her", "", "", "", "Click for more Details"},
                    {"Pillow Thoughts", "", "", "", "Click for more Details"},
                    {"The Sun and Her Flowers", "", "", "", "Click for more Details"},
                    {"Milk and Honey", "", "", "", "Click for more Details"},
            };
    private String[][] fictional =
            {
                    {"Coding Daily", "", "", "", "Click for more Details"},
                    {"Computer is life", "", "", "", "Click for more Details"},
                    {"Esc is key", "", "", "", "Click for more Details"},
                    {"Be a Coder", "", "", "", "Click for more Details"},
                    {"Healthy Gut", "", "", "", "Click for more Details"},
            };
    private String[][] motivational =
            {
                    {"Coding Daily", "", "", "", "Click for more Details"},
                    {"Computer is life", "", "", "", "Click for more Details"},
                    {"Esc is key", "", "", "", "Click for more Details"},
                    {"Be a Coder", "", "", "", "Click for more Details"},
                    {"Healthy Gut", "", "", "", "Click for more Details"},
            };

    private String[] poem_url={"https://drive.google.com/file/d/1CUt_D46xB0WLMgR0uOE6wfSJhnLkydCS/view?usp=share_link",
                            "https://drive.google.com/file/d/1nwMS22Q_KoZy5lhhm0rp3FSjZWg321P8/view?usp=share_link",
                            "https://drive.google.com/file/d/1gYf-5Hgo8u8ETAeigfQ8PMFk2Itnom9b/view?usp=share_link",
                            "https://drive.google.com/file/d/1TfFRUBkb-3sVqQbfMcAnduM4LA2vN1m4/view?usp=share_link",
                            "https://drive.google.com/file/d/1ZusnfkvIk_bmVke279QrbsOVJ0uoIPRZ/view?usp=share_link"
    };


    private String[] fic_url={
            "https://drive.google.com/file/d/1K4FKj2AtrCl9ETEPZx5BLfogFGrjvYeV/view?usp=share_link",
            "https://drive.google.com/file/d/12WaYMKF9s2w7AriSLocOyM1mnl_AVTIT/view?usp=share_link",
            "https://drive.google.com/file/d/1vxrme0SsVOOoP96SZnqSpopaCUWbCCdn/view?usp=share_link",
            "https://drive.google.com/file/d/1BYhofT7d6q2NOifpCsb3FapKLYzij6MK/view?usp=share_link",
            "https://drive.google.com/file/d/1K4FKj2AtrCl9ETEPZx5BLfogFGrjvYeV/view?usp=share_link"

    };

    private String[] motiv_url={
            "https://drive.google.com/file/d/1NXKT0tbByK8M9INWvvTetrfdDRcTb_mg/view?usp=share_link",
            "https://drive.google.com/file/d/1mjTw41EhbWzLaFYf3ohKwZca9DELtYxX/view?usp=share_link",
            "https://drive.google.com/file/d/1gOVtQyosFRKu4rW4gwEQjSCAF0JZmp3N/view?usp=share_link",
            "https://drive.google.com/file/d/1NXKT0tbByK8M9INWvvTetrfdDRcTb_mg/view?usp=share_link",
            "https://drive.google.com/file/d/1mjTw41EhbWzLaFYf3ohKwZca9DELtYxX/view?usp=share_link"
    };
    private String[] books = {};
    private String[] poem_des={"This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
    "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
     "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
     "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
     "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars."
    };
    private String[] moti_des={"This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars."
    };
    private String[] fic_des={"This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars.",
            "This best selling poetry book by Nikita Gill is about the journey of healing from trauma and becoming whole again. Directions: apply to your soul gently, whilst sitting under the stars."
    };


    TextView tv;
    String[][] book_details = {};
    String[] url={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    private int[] images={R.drawable.img3,R.drawable.fav1,R.drawable.hmpg,R.drawable.img2hp,R.drawable.img3};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_books);
        tv = findViewById(R.id.textViewBKTitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Fictional")==0){
            book_details=fictional;
            url=fic_url;
            books=fic_des;
        }
        else if(title.compareTo("Motivational")==0){
            book_details=motivational;
            url=motiv_url;
            books=moti_des;
        }
        else{
            url=poem_url;
            book_details=poems;
            books=poem_des;
        }

        list = new ArrayList();
        for (int i = 0; i < book_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("images", images[i] + "");
            item.put("line1", book_details[i][0]);
            item.put("line2", book_details[i][1]);
            item.put("line3", book_details[i][2]);
            item.put("line4", book_details[i][3]);
            item.put("line5", book_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"images","line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.imageView,R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewBK);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(SeeBooks.this, BookDetailsActivity.class);
                it.putExtra("text1", book_details[position][0]);
                it.putExtra("text2", books[position]);
                it.putExtra("text3", url[position]);
                startActivity(it);
            }
        });
    }
}
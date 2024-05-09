package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Album extends AppCompatActivity {
    ListView lv;
    ImageButton homeBtn, aboutBtn, logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        homeBtn = findViewById(R.id.homeBtn1);
        aboutBtn = findViewById(R.id.aboutBtn1);
        logoutBtn = findViewById(R.id.logoutBtn1);

        String username = getIntent().getExtras().getString("name");

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Album.this, Home.class);
                intent.putExtra("userInput",username);
                startActivity(intent);
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Album.this, About.class);
                intent.putExtra("name",username);
                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Album.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv = findViewById(R.id.listView1);
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Times", "SG Lewis", "Dance", "75.000","192.320 copy", R.drawable.album6));
        chats.add(new Chat("Dusk", "SG Lewis", "Disco", "57.000","192.394 copy", R.drawable.album2));
        chats.add(new Chat("Shivers", "SG Lewis", "Pop", "21.000","180.000 copy", R.drawable.album5));
        chats.add(new Chat("Hurting", "SG Lewis", "Lo-Fi", "45.000","185.358 copy", R.drawable.album4));
        chats.add(new Chat("Yours", "SG Lewis", "Dance", "39.000","165.399 copy", R.drawable.album7));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(Album.this, Detail.class);
                    Bundle b = new Bundle();
                    b.putInt("img", R.drawable.album6);
                    intent.putExtras(b);
                    intent.putExtra("title", "Times");
                    intent.putExtra("name", "SG Lewist");
                    intent.putExtra("cate", "Dance");
                    intent.putExtra("price", "75.000");
                    intent.putExtra("sold", "192.320 copy");
                    startActivity(intent);
                }
                if(position == 1) {
                    Intent intent = new Intent(Album.this, Detail.class);
                    Bundle b = new Bundle();
                    b.putInt("img", R.drawable.album2);
                    intent.putExtras(b);
                    intent.putExtra("title", "Dusk");
                    intent.putExtra("name", "SG Lewis");
                    intent.putExtra("cate", "Disco");
                    intent.putExtra("price", "57.000");
                    intent.putExtra("sold", "192.394 copy");
                    startActivity(intent);
                }
                if(position == 2) {
                    Intent intent = new Intent(Album.this, Detail.class);
                    Bundle b = new Bundle();
                    b.putInt("img", R.drawable.album5);
                    intent.putExtras(b);
                    intent.putExtra("title", "Shivers");
                    intent.putExtra("name", "SG Lewis");
                    intent.putExtra("cate", "Pop");
                    intent.putExtra("price", "21.000");
                    intent.putExtra("sold", "180.000 copy");
                    startActivity(intent);
                }
                if(position == 3) {
                    Intent intent = new Intent(Album.this, Detail.class);
                    Bundle b = new Bundle();
                    b.putInt("img", R.drawable.album4);
                    intent.putExtras(b);
                    intent.putExtra("title", "Hurting");
                    intent.putExtra("name", "SG Lewis");
                    intent.putExtra("cate", "Lo-Fi");
                    intent.putExtra("price", "45.000");
                    intent.putExtra("sold", "185.358 copy");
                    startActivity(intent);
                }
                if(position == 4) {
                    Intent intent = new Intent(Album.this, Detail.class);
                    Bundle b = new Bundle();
                    b.putInt("img", R.drawable.album7);
                    intent.putExtras(b);
                    intent.putExtra("title", "Yours");
                    intent.putExtra("name", "SG Lewis");
                    intent.putExtra("cate", "Dance");
                    intent.putExtra("price", "39.000");
                    intent.putExtra("sold", "165.399 copy");
                    startActivity(intent);
                }
            }
        });

        AdapterList adp = new AdapterList(this, R.layout.list,chats);
        lv.setAdapter(adp);
    }
}
package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    TextView name;
    int images[]= {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    ImageButton albumBtn, aboutBtn, logoutBtn;
    ViewFlipper vp;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        albumBtn = findViewById(R.id.albumBtn);
        aboutBtn = findViewById(R.id.aboutBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
        String username = getIntent().getExtras().getString("userInput");
        name = findViewById(R.id.username);
        name.setText("Welcome, "+username+"!");

        albumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Album.class);
                intent.putExtra("name",username);
                startActivity(intent);
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, About.class);
                intent.putExtra("name",username);
                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv = findViewById(R.id.listView);
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Presence", "Petit Biscuit", "Dance", "60.000","10.000 copy", R.drawable.album1));
        chats.add(new Chat("Dusk", "SG Lewis", "Disco", "57.000","192.394 copy", R.drawable.album2));
        chats.add(new Chat("24K magic", "Bruno Uranus", "Pop", "24.000","182.019 copy", R.drawable.album3));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position == 0) {
                   Intent intent = new Intent(Home.this, Detail.class);
                   Bundle b = new Bundle();
                   b.putInt("img", R.drawable.album1);
                   intent.putExtras(b);
                   intent.putExtra("title", "Presence");
                   intent.putExtra("name", "Petit Biscuit");
                   intent.putExtra("cate", "Dance");
                   intent.putExtra("price", "60.000");
                   intent.putExtra("sold", "10.000 copy");
                   startActivity(intent);
               }
                if(position == 1) {
                    Intent intent = new Intent(Home.this, Detail.class);
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
                    Intent intent = new Intent(Home.this, Detail.class);
                    Bundle b = new Bundle();
                    b.putInt("img", R.drawable.album3);
                    intent.putExtras(b);
                    intent.putExtra("title", "24K magic");
                    intent.putExtra("name", "Bruno Uranus");
                    intent.putExtra("cate", "Pop");
                    intent.putExtra("price", "24.000");
                    intent.putExtra("sold", "182.019 copy");
                    startActivity(intent);
                }
            }
        });

        AdapterList adp = new AdapterList(this, R.layout.list,chats);
        lv.setAdapter(adp);


        vp = findViewById(R.id.imgcrs);
        for(int image:images){
            slideimg(image);
        }


    }
    private void slideimg(int image){
        ImageView img = new ImageView(this);
        img.setBackgroundResource(image);
        vp.addView(img);
        vp.setFlipInterval(3000);
        vp.setAutoStart(true);
        vp.setInAnimation(this, android.R.anim.slide_in_left);
        vp.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView name;
    ImageButton homeBtn, albumBtn, logoutBtn;
    Button mapBtn, infoBtn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        homeBtn = findViewById(R.id.homeBtn2);
        albumBtn = findViewById(R.id.albumBtn2);
        logoutBtn = findViewById(R.id.logoutBtn2);
        mapBtn = findViewById(R.id.map);
        infoBtn = findViewById(R.id.info);
        img = findViewById(R.id.changeimg);
        String username = getIntent().getExtras().getString("name");
        name = findViewById(R.id.username1);
        name.setText("Welcome, "+username+"!");

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, Home.class);
                intent.putExtra("userInput",username);
                startActivity(intent);
            }
        });

        albumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, Album.class);
                intent.putExtra("name",username);
                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.map);
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.information);
            }
        });
    }
}
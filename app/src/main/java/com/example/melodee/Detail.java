package com.example.melodee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    ImageView img;
    TextView title, name, category, price, sold;
    Button order;
    EditText quantity;
    int count = 0;
    ActionBar act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        act = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img = findViewById(R.id.detAlb);
        title = findViewById(R.id.detTtl);
        name = findViewById(R.id.detArt);
        category = findViewById(R.id.detCat);
        price = findViewById(R.id.detPrice);
        sold = findViewById(R.id.detSold);
        order = findViewById(R.id.orderBtn);
        quantity = findViewById(R.id.qty);

        Intent intent = getIntent();
        Bundle b = this.getIntent().getExtras();
        int alImg = b.getInt("img");
        String alTtl = intent.getStringExtra("title");
        String alName = intent.getStringExtra("name");
        String alCat = intent.getStringExtra("cate");
        String alPrice = intent.getStringExtra("price");
        String alSold = intent.getStringExtra("sold");

        img.setImageResource(alImg);
        title.setText(alTtl);
        name .setText(alName);
        category.setText(alCat);
        price.setText(alPrice);
        sold.setText(alSold);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity.getText().toString().isEmpty()||quantity.getText().toString().equals("0")){
                    count = 0;
                    dialog();
                }
                else{
                    count = 1;
                    dialog();
                }
            }
        });

    }
    public void dialog(){
        if(count == 0){
            NotifDialog n = new NotifDialog();
            n.show(getSupportFragmentManager(),"Order Dialog");
        }
        else if(count == 1){
            successDialog n = new successDialog();
            n.show(getSupportFragmentManager(),"Order Dialog");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
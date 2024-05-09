 package com.example.melodee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
    Button regisBtn;
    EditText userInput;
    EditText passInput;
    EditText name;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regisBtn = findViewById(R.id.regist);
        userInput = findViewById(R.id.userInput);
        passInput = findViewById(R.id.passInput);
        error = findViewById(R.id.error);


        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInput.getText().toString().isEmpty()){
                    error.setText("Email Must be Filled");
                }
                else if(passInput.getText().toString().isEmpty()){
                    error.setText("Password Must be Filled");
                }
                else{
                    for(int i = 0; i < passInput.getText().toString().length();i++){
                        char alphanumeric = passInput.getText().toString().charAt(i);
                        if(Character.isLetterOrDigit(alphanumeric)){
                            Home(v);
                            break;
                        }
                        else{
                            error.setText("Password must be Alphanumeric");
                        }
                    }
                }
            }
        });


    }

     public void Home(View view) {
         Intent intent = new Intent(MainActivity.this, Home.class);
         intent.putExtra("userInput", userInput.getText().toString());
         startActivity(intent);
     }
 }
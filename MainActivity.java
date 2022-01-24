package com.example.employee_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonman ,emplogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonman=(Button) findViewById(R.id.buttonman);
        emplogin=(Button)findViewById(R.id.emplogin);
        buttonman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),manager_login.class);
                startActivity(intent);
            }
        });
        emplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),employee_login.class);
                startActivity(intent);

            }
        });
    }
}

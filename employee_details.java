package com.example.employee_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class employee_details extends AppCompatActivity {
    Button backk,SAVE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        backk=(Button)findViewById(R.id.backk);
        SAVE=(Button)findViewById(R.id.SAVE);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z=new Intent(getBaseContext(),employee_home.class);
                startActivity(z);
            }
        });
        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "new data inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

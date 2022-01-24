package com.example.employee_management;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class manager_home extends AppCompatActivity {
    Button add,log,salcalculate,atst;
    DbHelper11 db1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);
        add=(Button) findViewById(R.id.empdetails);
        atst=(Button)findViewById(R.id.logout);
        db1 = new DbHelper11(this);
        log=(Button)findViewById(R.id.log);

        salcalculate=(Button)findViewById(R.id.att);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),add_employee.class);
                startActivity(intent);

            }

        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getBaseContext(),MainActivity.class);
                startActivity(inten);
                Toast.makeText(getApplicationContext(), "USER LOGGED OUT!", Toast.LENGTH_SHORT).show();

            }

        });


        salcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(getBaseContext(),salary_calculation.class);
                startActivity(ii);

            }
        });

        atst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db1.getUserData();
                if(res.getCount()==0){
                    Toast.makeText(manager_home.this, "No Data Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name: "+res.getString(0)+"\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(manager_home.this);
                builder.setCancelable(true);
                builder.setTitle("User Data");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


    }
}

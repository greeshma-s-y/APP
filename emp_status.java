package com.example.employee_management;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.widget.TextView;
import android.widget.Toast;



public class emp_status extends AppCompatActivity {
    String[] name2 ={"Chiranthana","Greeshma","cccc","chaithanaya","gg","gagana"};


    Button save,show;
    DbHelper11 db1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_status);
        db1 = new DbHelper11(this);

        show=(Button)findViewById(R.id.show);
        save=(Button)findViewById(R.id.save);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,name2);
        AutoCompleteTextView actv =  (AutoCompleteTextView)findViewById(R.id.name2);
        actv.setThreshold(1);
        actv.setAdapter(adapter);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = actv.getText().toString();
                Boolean insertData = db1.insertUserData(nameTxt);
                if(insertData){
                    Toast.makeText(emp_status.this, "New Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(emp_status.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db1.getUserData();
                if(res.getCount()==0){
                    Toast.makeText(emp_status.this, "No Data Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name: "+res.getString(0)+"\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(emp_status.this);
                builder.setCancelable(true);
                builder.setTitle("User Data");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });










    }
}

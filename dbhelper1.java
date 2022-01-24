package com.example.employee_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class dbhelper1 extends SQLiteOpenHelper {
    public dbhelper1(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE salary(empid TEXT PRIMARY KEY,empsalary TEXT,empovertime TEXT,empincometax TEXT,empprofessional TEXT,emptransportation TEXT,empfinalsal TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists salary");
    }

    public Boolean insertUserData(String empid, String empsalary, String empovertime, String empincometax, String empprofessional , String emptransportation , String empfinalsal ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("empid", empid);
        contentValues.put("empsalary", empsalary);
        contentValues.put("empovertime", empovertime);
        contentValues.put("empincometax", empincometax);
        contentValues.put("empprofessional", empprofessional);
        contentValues.put("emptransportation", emptransportation);
        contentValues.put("empfinalsal", empfinalsal);
        long res = db.insert("salary", null, contentValues);
        if (res == -1) {
            return false;
        } else
            return true;
    }

   /* public Boolean updateUserData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = db.rawQuery("SELECT * FROM salary WHERE name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long res = db.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (res == -1) {
                return false;
            } else
                return true;
        } else
            return false;
    }

    public Boolean deleteUserData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails WHERE name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long res = db.delete("Userdetails", "name=?", new String[]{name});
            if (res == -1) {
                return false;
            } else
                return true;
        } else
            return false;
    }*/

    public Cursor getUserData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM salary", null);
        return cursor;
    }
}

package com.example.urja.tollproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urja on 06-01-2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 29;

    // Database Name
    private static final String DATABASE_NAME = "tollSystem";

    // Contacts table name
    private static final String TABLE_CONTACTS = "historydetails";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TOLL_ID = "tollid";
    private static final String KEY_RATE = "rate";
    private static final String KEY_PAID="paid";
    public static final String KEY_DATE="date";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TOLL_ID + " TEXT,"
                + KEY_RATE + " TEXT," + KEY_PAID + " TEXT,"+ KEY_DATE + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    public void addHistory(HistoryDetails h)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TOLL_ID, h.get_TOLL_ID()); // Contact Name
        values.put(KEY_RATE,h.get_rate());
        values.put(KEY_PAID,h.get_paid());
        values.put(KEY_DATE,h.get_date());// Contact Phone Number

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    public List<HistoryDetails> getAllHistory() {
        List<HistoryDetails> HistoryList = new ArrayList<HistoryDetails>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HistoryDetails hd=new HistoryDetails();
                hd.set_id(Integer.parseInt(cursor.getString(0)));
                hd.set_TOLL_ID(cursor.getString(1));
                hd.set_rate(Double.parseDouble(cursor.getString(2)));
                hd.set_paid(cursor.getString(3));
                hd.set_date(cursor.getString(4));
                // Adding contact to list
                HistoryList.add(hd);
            } while (cursor.moveToNext());
        }

        // return contact list
        return HistoryList;
    }
    public List<HistoryDetails> getAllBills()
    {
        List<HistoryDetails> HistoryList = new ArrayList<HistoryDetails>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " WHERE paid='"+"N"+"'";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HistoryDetails hd=new HistoryDetails();
                hd.set_id(Integer.parseInt(cursor.getString(0)));
                hd.set_TOLL_ID(cursor.getString(1));
                hd.set_rate(Double.parseDouble(cursor.getString(2)));
                hd.set_paid(cursor.getString(3));
                hd.set_date(cursor.getString(4));
                // Adding contact to list
                HistoryList.add(hd);
            } while (cursor.moveToNext());
        }

        // return contact list
        return HistoryList;
    }
    public int updateHistory()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_PAID,"Y");
        return db.update(TABLE_CONTACTS,cv,KEY_PAID+"=?",new String[]{"N"});
    }
}

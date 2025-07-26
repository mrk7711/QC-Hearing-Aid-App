package com.example.cab2u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "HearingAid.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "AB_library";
    private static final String TABLE_NAME1 = "DB_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "Serial_Number";
    private static final String COLUMN_AUTHOR = "MAX_OSPL90";
    private static final String COLUMN_PAGES = "HFA_OSPL90";
    private static final String COLUMN_PAGES2 = "FOG";
    private static final String COLUMN_PAGES3 = "EIN";
    private static final String COLUMN_PAGES4 = "Current";
    private static final String COLUMN_PAGES5 = "THD500";
    private static final String COLUMN_PAGES6 = "THD800";
    private static final String COLUMN_PAGES7 = "THD1600";

    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_PAGES + " TEXT, " +
                COLUMN_PAGES2 + " TEXT, " +
                COLUMN_PAGES3 + " TEXT, " +
                COLUMN_PAGES4 + " TEXT, " +
                COLUMN_PAGES5 + " TEXT, " +
                COLUMN_PAGES6 + " TEXT, " +
                COLUMN_PAGES7 + " TEXT);";
        db.execSQL(query);
        String query2 = "CREATE TABLE " + TABLE_NAME1 +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_PAGES + " TEXT, " +
                COLUMN_PAGES2 + " TEXT, " +
                COLUMN_PAGES3 + " TEXT, " +
                COLUMN_PAGES4 + " TEXT, " +
                COLUMN_PAGES5 + " TEXT, " +
                COLUMN_PAGES6 + " TEXT, " +
                COLUMN_PAGES7 + " TEXT);";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    void addHearingAid(String title, String author, String pages, String pages2, String pages3, String pages4, String pages5, String pages6, String pages7){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        cv.put(COLUMN_PAGES2, pages2);
        cv.put(COLUMN_PAGES3, pages3);
        cv.put(COLUMN_PAGES4, pages4);
        cv.put(COLUMN_PAGES5, pages5);
        cv.put(COLUMN_PAGES6, pages6);
        cv.put(COLUMN_PAGES7, pages7);

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    void addHearingAid2(String title, String author, String pages, String pages2, String pages3, String pages4, String pages5, String pages6, String pages7){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        cv.put(COLUMN_PAGES2, pages2);
        cv.put(COLUMN_PAGES3, pages3);
        cv.put(COLUMN_PAGES4, pages4);
        cv.put(COLUMN_PAGES5, pages5);
        cv.put(COLUMN_PAGES6, pages6);
        cv.put(COLUMN_PAGES7, pages7);

        long result = db.insert(TABLE_NAME1,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllData2(){
        String query = "SELECT * FROM " + TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    void updateData(String row_id, String title, String author, String pages, String pages2, String pages3, String pages4, String pages5, String pages6, String pages7){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        cv.put(COLUMN_PAGES2, pages2);
        cv.put(COLUMN_PAGES3, pages3);
        cv.put(COLUMN_PAGES4, pages4);
        cv.put(COLUMN_PAGES5, pages5);
        cv.put(COLUMN_PAGES6, pages6);
        cv.put(COLUMN_PAGES7, pages7);
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void updateData2(String row_id, String title, String author, String pages, String pages2, String pages3, String pages4, String pages5, String pages6, String pages7){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        cv.put(COLUMN_PAGES2, pages2);
        cv.put(COLUMN_PAGES3, pages3);
        cv.put(COLUMN_PAGES4, pages4);
        cv.put(COLUMN_PAGES5, pages5);
        cv.put(COLUMN_PAGES6, pages6);
        cv.put(COLUMN_PAGES7, pages7);
        long result = db.update(TABLE_NAME1, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow2(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME1, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    void deleteAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME1);
    }
}

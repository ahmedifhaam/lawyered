package com.mit.lawyered.controller.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mit.lawyered.models.Contact;

/**
 * Created by S.T.Sarma on 5/9/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "layered.db";
    private static final String TABLE_NAME = "user";
    private static final String TABLE_NAME2 = "thirdparty";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASS = "password";
    private static final String COL_CONTACT = "contact";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_TYPE = "type";
    private static final String COL_THIRDTYPE = "third_type";
    SQLiteDatabase db;

    private static final String TABLE_CREATE ="create table user(id integer primary key not null auto_increment," + " name text not null," + "username text not null," +
            "password text not null," + "balance int not null," + "type text not null,";

    private static final String TABLE_CREATE2 ="create table thirdparty(tid integer primary key not null auto_increment," + " id int not null," +
            "contact text not null," + "description text not null," + "type text not null," + "review int";


    public DatabaseHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }





    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,c.getName());
        values.put(COL_USERNAME,c.getUname());
        values.put(COL_PASS,c.getPass());
        values.put(COL_TYPE,c.getType());
        db.insert(TABLE_NAME,null,values);

        if(c.getType().equals("o"))
        {

            int count = getid();
            ContentValues values2 = new ContentValues();
            values2.put(COL_CONTACT,c.getContact());
            values2.put(COL_DESCRIPTION,c.getDescription());
            values2.put(COL_THIRDTYPE,c.getThirdtype());
            values2.put(COL_ID,count);
            db.insert(TABLE_NAME2,null,values2);
        }

        db.close();

    }

    public int getid(){
        int count;
        db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        count = cursor.getCount();
        return count;
    }

    public String searchpass(String uname){

        db = this.getReadableDatabase();
        String query = "select uname,pass from"+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String username,password;
        password = "not foound";
        if(cursor.moveToFirst()){

            do{

                username = cursor.getString(0);

                if(username.equals(uname)) {
                    password = cursor.getString(1);
                    break;
                }


            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return password;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
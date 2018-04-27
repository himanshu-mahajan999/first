package com.it.himanshu.crudsqllite.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.it.himanshu.crudsqllite.Model.Employee;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Himanshu on 16/01/2018.
 */

public class Dbhelper extends SQLiteOpenHelper
{
    Context context;
    public static final String DB_TEST = "myemployeedatabase";

    public Dbhelper(Context context){
        super(context, DB_TEST, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("create table employees(id INTEGER NOT NULL primary key autoincrement , " +
                "name varchar(200) NOT NULL,\n" +
                "department varchar(200) NOT NULL,\n" +
                "joiningdate datetime NOT NULL,\n" +
                "salary real NOT NULL\n" +
                ")");

        sqLiteDatabase.execSQL("create table chat(id INTEGER NOT NULL primary key autoincrement , " +
                "chat1 varchar(200) NOT NULL,\n" +
                "chat2 varchar(200) NOT NULL\n"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

   /* public boolean chat(String one, String two) {

        SQLiteDatabase db = getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();

            cv.put("chat1", one);
            cv.put("chat2", two);

            db.insert("chat", null, cv);
            //db.insert("RECENTS", null, cv);
            return  true;

        } catch (SQLiteException ex) {
            return false;
        }
    }*/

    public void dbput( String name,String salary,String dept,String joiningDate) {

        SQLiteDatabase db = getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();

            cv.put("name", name);
            cv.put("department", dept);
            cv.put("joiningDate", joiningDate);
            cv.put("salary", salary);
            db.insert("employees", null, cv);
            //db.insert("RECENTS", null, cv);

        } catch (SQLiteException ex) {

        }
    }

  /*  public  ArrayList<ChatM> getChat() {
        ArrayList<ChatM> stList = new ArrayList<ChatM>();

        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from chat;";
        Cursor cur = db.rawQuery(query, null);

        while (cur.moveToNext()) {

            int id = cur.getInt(0);
            String chat1 = cur.getString(1);
            String chat2 = cur.getString(2);

            ChatM Model = new ChatM(id, chat1, chat2);
            stList.add(Model);
        }
        cur.close();
        db.close();
        return stList;
    }*/
    public  ArrayList<Employee> getdata(){
        ArrayList<Employee> stList = new ArrayList<Employee>();

        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from  employees ;";
        Cursor cur = db.rawQuery(query, null);

        while (cur.moveToNext()) {

            int id = cur.getInt(0);
            String name = cur.getString(1);
            String dept = cur.getString(2);
            String joiningDate = cur.getString(3);
            Double salary = cur.getDouble(4);
            Employee Model = new Employee( id,name, dept, joiningDate,  salary);
            stList.add(Model);
        }
        cur.close();
        db.close();
        return  stList;
    }

    public boolean delete(int id)
    {

        String query = "DELETE FROM employees WHERE id ='"+ id+"'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);

        return true;
    }

    public void editDb( int id,String name,String salary)
    {

        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues newValues = new ContentValues();
            newValues.put("name", name);
            newValues.put("salary", salary);

            db.update("employees", newValues, "id="+id, null);
            Log.e("error","error naa");
            
        }
        catch (Exception e)
        {
           Log.e("error db","error");
        }
    }
   /* public boolean isTableExists(String tableName, boolean openDb) {
       SQLiteDatabase mDatabase = new SQLiteDatabase();
        // / SQLiteDatabase mDatabase = new SQLiteDatabase();
        if(openDb) {
            if(mDatabase == null || !mDatabase.isOpen()) {
                mDatabase = getReadableDatabase();
            }

            if(!mDatabase.isReadOnly()) {
                mDatabase.close();
                mDatabase = getReadableDatabase();
            }
        }

        Cursor cursor = mDatabase.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }*/
   public boolean CheckDatabase(Context context)
   {
       boolean b = false;
   File database = context.getDatabasePath("sqlite.db");
   if (!database.exists())
   {
       b = false;
       // Database does not exist so copy it from assets here
                Log.e("Database", "Not Found");
   }
   else
       {
           b = true;
           Log.e("Database", "Found");
       }        return b;
}

}
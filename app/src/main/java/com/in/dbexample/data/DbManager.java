package com.in.dbexample.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class DbManager {

    static SQLiteDatabase mDb = null ;
    Context mcontext = null;

    public DbManager(Context context){
//        mcontext = context ;
        mDb = new DBHelper(context).getWritableDatabase();
    }



    public class DBHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "mytest.mDb";
        private static final int VERSION = 1;

        String CreateContactsTable = "CREATE TABLE "+ Contacts.TABLE_NAME +"("+
                Contacts._ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Contacts.NAME +" text,"+
                Contacts.NUMBER+" text )" ;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CreateContactsTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+Contacts.TABLE_NAME);
            onCreate(db);
        }
    }

    // class to represent contacts table
    public static class Contacts implements BaseColumns{

        public static final String TABLE_NAME = "my_contacts";
        public static final String NAME = "name";
        public static final String NUMBER = "number";

    }

    public long insertData(String name, String number){

        ContentValues rowValues = new ContentValues() ;

        rowValues.put(Contacts.NAME, name);
        rowValues.put(Contacts.NUMBER, number);

        long rowId = mDb.insert(Contacts.TABLE_NAME, null, rowValues);

        return rowId ;

    }

    public Cursor getContactList() {

        Cursor c = mDb.query(Contacts.TABLE_NAME, null,null ,null ,null ,null , Contacts.NAME) ;

        return c;

    }

}

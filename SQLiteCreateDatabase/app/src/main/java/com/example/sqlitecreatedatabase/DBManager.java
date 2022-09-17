package com.example.sqlitecreatedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBManager {

    private SQLiteDatabase sqLiteDatabase;

    static final String DBName = "Student";
    static final String TableName = "Logins";
    static final String ColUseName = "UserName";
    static final String ColPassword = "Password";
    static final int DBVersion = 1;

    // SQL Command: CREATE TABLE LOGINS (ID INTEGER PRIMARY KEY AUROINCREMENT, USERNAME TEXT, PASSWORD TEXT);
    static final String createTable = "Create table IF NOT EXISTS " + TableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + ColUseName + " text" + ColPassword + "text)";
    static class DatabaseHelper extends SQLiteOpenHelper {
        Context context;
        DatabaseHelper(Context context){
            super(context, DBName, null, DBVersion);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(createTable);
            Toast.makeText(context, "Table is Created", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Drop table IF EXISTS " + TableName);
            onCreate(sqLiteDatabase);
        }
    }

    public DBManager(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
}

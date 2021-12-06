package com.example.damapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,EMAIL TEXT, DOB TEXT, PASS TEXT , ADDRESS TEXT)")
        db?.execSQL("INSERT INTO USERS(NAME,EMAIL,DOB,PASS,ADDRESS) VALUES('NAGEENIMRAN','nageenimran@gmail.com','02/10/2000','Mirza','SIKANDARBLOCK')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
class
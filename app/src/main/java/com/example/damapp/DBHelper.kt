package com.example.damapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,EMAIL TEXT, DOB TEXT, PASS TEXT , ADDRESS TEXT)")
        db?.execSQL("CREATE TABLE ACTIVITY(USERID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,DES TEXT )")
        db?.execSQL("INSERT INTO ACTIVITY(TITLE,DES) VALUES('DRINK WATER','DRINK WATER EVERY FKN HOUR')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
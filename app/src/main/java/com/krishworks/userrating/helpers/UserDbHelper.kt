package com.krishworks.userrating.helpers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.krishworks.userrating.data.*

class UserDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "UserRating.db"
        private const val DATABASE_VERSION = 1

        private const val SQL_CREATE_ENTRIES =
            ("CREATE TABLE " + TABLE_NAME.toString() + " ("
                    + _ID.toString() + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_RATING.toString() + " TEXT NOT NULL, "
                    + COLUMN_TIME.toString() + " TEXT NOT NULL, "
                    + COLUMN_DATE.toString() + " TEXT NOT NULL);")

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS  $TABLE_NAME"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}
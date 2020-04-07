package com.krishworks.userrating

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.krishworks.userrating.data.*
import com.krishworks.userrating.helpers.UserDbHelper
import kotlinx.android.synthetic.main.activity_rating_history.*

class RatingHistoryActivity : AppCompatActivity() {

    private val data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_history)

        readData()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        list_view.adapter = arrayAdapter
    }

    private fun readData() {
        val userDbHelper = UserDbHelper(this)

        val db: SQLiteDatabase = userDbHelper.readableDatabase

        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.count == 0) {
            Toast.makeText(this, "DB is empty", Toast.LENGTH_SHORT).show()
            return
        }

        while (cursor.moveToNext()) {
            val value = "${cursor.getInt(0)}   ${cursor.getString(1)}  ${cursor.getString(2)}  ${cursor.getString(3)}"
            data.add(value)
        }

        cursor.close()
    }
}
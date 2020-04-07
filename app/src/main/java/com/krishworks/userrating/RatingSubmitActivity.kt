package com.krishworks.userrating

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krishworks.userrating.data.*
import com.krishworks.userrating.helpers.UserDbHelper
import kotlinx.android.synthetic.main.activity_rating_submit.*
import java.text.SimpleDateFormat
import java.util.*

class RatingSubmitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_submit)

        // set maximum rating
        rating_bar.numStars = max_rating
        // set step size of rating
        rating_bar.stepSize = 0.5f
        // set minimum rating
        rating_bar.rating = min_rating.toFloat()
        rating_bar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            if (rating < min_rating) {
                ratingBar.rating = min_rating.toFloat()
            }
        }

        // submit rating
        submit_btn.setOnClickListener {
            if (submit_btn.text == "FINISH") {
                finish()
                return@setOnClickListener
            }
            submit_btn.text = "FINISH"
            submit_btn.setTextColor(resources.getColor(R.color.colorPrimaryDark))

            val value = rating_bar.rating
            rating_bar.setIsIndicator(true)

            insertData(value.toString(), currentTime(), currentDate())
        }
    }

    private fun currentTime(): String {
        val sdf = SimpleDateFormat("HH:mm:ss")
        val resultDate = Date(System.currentTimeMillis())
        return sdf.format(resultDate)
    }

    private fun currentDate(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val resultDate = Date(System.currentTimeMillis())
        return sdf.format(resultDate)
    }

    private fun insertData(rating: String, time: String, date: String) {
        val userDbHelper = UserDbHelper(this)

        val db: SQLiteDatabase = userDbHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COLUMN_RATING, rating)
        contentValues.put(COLUMN_TIME, time)
        contentValues.put(COLUMN_DATE, date)

        val result = db.insert(TABLE_NAME, null, contentValues)

        if (result.equals(-1)) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }
    }
}

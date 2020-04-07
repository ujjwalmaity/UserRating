package com.krishworks.userrating

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krishworks.userrating.data.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit_rating_btn.setOnClickListener {
            val intent = Intent(this, RatingSubmitActivity::class.java)
            startActivity(intent)
        }

        history_rating_btn.setOnClickListener {
            val intent = Intent(this, RatingHistoryActivity::class.java)
            startActivity(intent)
        }

        modify_rating_range_btn.setOnClickListener {
            val intent = Intent(this, RatingRangeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        submit_rating_btn.text = "Rating $min_rating-$max_rating"
    }
}

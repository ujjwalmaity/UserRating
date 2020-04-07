package com.krishworks.userrating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.krishworks.userrating.data.*
import kotlinx.android.synthetic.main.activity_rating_range.*

class RatingRangeActivity : AppCompatActivity() {

    var min = 0
    var max = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_range)

        min_radio_group.setOnCheckedChangeListener { group, checkedId ->
            val view: RadioButton = group.findViewById(checkedId)
            min = view.text.toString().trim().toInt()
        }

        max_radio_group.setOnCheckedChangeListener { group, checkedId ->
            val view: RadioButton = group.findViewById(checkedId)
            max = view.text.toString().trim().toInt()
        }

        modify_range.setOnClickListener {
            if (min < max) {
                min_rating = min
                max_rating = max
                finish()
            } else {
                Toast.makeText(this, "Please select a valid range", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
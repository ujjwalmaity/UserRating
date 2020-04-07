package com.krishworks.userrating.data

import android.provider.BaseColumns

var min_rating: Int = 1
var max_rating: Int = 5

const val TABLE_NAME = "user_rating"

const val _ID = BaseColumns._ID

const val COLUMN_RATING = "rating"
const val COLUMN_TIME = "time"
const val COLUMN_DATE = "date"
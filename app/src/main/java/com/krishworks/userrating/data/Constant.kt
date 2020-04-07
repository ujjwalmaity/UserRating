package com.krishworks.userrating.data

import android.provider.BaseColumns

const val min_rating: Int = 1
const val max_rating: Int = 5

const val TABLE_NAME = "user_rating"

const val _ID = BaseColumns._ID

const val COLUMN_RATING = "rating"
const val COLUMN_TIME = "time"
const val COLUMN_DATE = "date"
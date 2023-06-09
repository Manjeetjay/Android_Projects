package com.example.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

class Grid(
    @StringRes val stringResourceID: Int,
    @IntegerRes val dataResource: Int,
    @DrawableRes val imageResourceID: Int
)

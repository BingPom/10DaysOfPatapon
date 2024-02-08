package com.example.a10daysofpatapon.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Patapon(
    @StringRes var name: Int,
    @StringRes var description: Int,
    @DrawableRes var image: Int
)

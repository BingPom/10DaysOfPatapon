package com.example.a10daysofpatapon.model

import com.example.a10daysofpatapon.R

class Datasource {
    private val patapons = listOf(
        Patapon(
            name = R.string.hatapon_name,
            description = R.string.hatapon_description,
            image = R.drawable.hatapon
        ),
        Patapon(
            name = R.string.yaripon_name,
            description = R.string.yaripon_description,
            image = R.drawable.yaripon
        ),
        Patapon(
            name = R.string.tatepon_name,
            description = R.string.tatepon_description,
            image = R.drawable.tatepon
        ),
        Patapon(
            name = R.string.yumipon_name,
            description = R.string.yumipon_description,
            image = R.drawable.yumipon
        ),
        Patapon(
            name = R.string.kibapon_name,
            description = R.string.kibapon_description,
            image = R.drawable.kibapon
        ),
        Patapon(
            name = R.string.dekapon_name,
            description = R.string.dekapon_description,
            image = R.drawable.dekapon
        ),
        Patapon(
            name = R.string.megapon_name,
            description = R.string.megapon_description,
            image = R.drawable.megapon
        ),
        Patapon(
            name = R.string.toripon_name,
            description = R.string.toripon_description,
            image = R.drawable.toripon
        ),
        Patapon(
            name = R.string.robopon_name,
            description = R.string.robopon_description,
            image = R.drawable.robopon
        ),
        Patapon(
            name = R.string.mahopon_name,
            description = R.string.mahopon_description,
            image = R.drawable.mahopon
        )
    )

    fun getData(): List<Patapon> {
        return patapons
    }
}
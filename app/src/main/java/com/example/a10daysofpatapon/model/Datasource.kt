package com.example.a10daysofpatapon.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class Datasource {
    private val COLLECTION_NAME = "patapon"

    private val NAME_FIELD = "name"
    private val DESCRIPTION_FIELD = "description"
    private val IMAGE_FIELD = "image"

    private val db = FirebaseFirestore.getInstance()
    private val pataponDB = db.collection(COLLECTION_NAME)



//    private val patapons = listOf(
//        Patapon(
//            name = R.string.hatapon_name,
//            description = R.string.hatapon_description,
//            image = R.drawable.hatapon
//        ),
//        Patapon(
//            name = R.string.yaripon_name,
//            description = R.string.yaripon_description,
//            image = R.drawable.yaripon
//        ),
//        Patapon(
//            name = R.string.tatepon_name,
//            description = R.string.tatepon_description,
//            image = R.drawable.tatepon
//        ),
//        Patapon(
//            name = R.string.yumipon_name,
//            description = R.string.yumipon_description,
//            image = R.drawable.yumipon
//        ),
//        Patapon(
//            name = R.string.kibapon_name,
//            description = R.string.kibapon_description,
//            image = R.drawable.kibapon
//        ),
//        Patapon(
//            name = R.string.dekapon_name,
//            description = R.string.dekapon_description,
//            image = R.drawable.dekapon
//        ),
//        Patapon(
//            name = R.string.megapon_name,
//            description = R.string.megapon_description,
//            image = R.drawable.megapon
//        ),
//        Patapon(
//            name = R.string.toripon_name,
//            description = R.string.toripon_description,
//            image = R.drawable.toripon
//        ),
//        Patapon(
//            name = R.string.robopon_name,
//            description = R.string.robopon_description,
//            image = R.drawable.robopon
//        ),
//        Patapon(
//            name = R.string.mahopon_name,
//            description = R.string.mahopon_description,
//            image = R.drawable.mahopon
//        )
//    )

    fun getData(setLista: (List<Patapon>) -> Unit) {
        val patapons = mutableListOf<Patapon>()

        pataponDB.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val name = document.getString(NAME_FIELD) ?: ""
                val description = document.getString(DESCRIPTION_FIELD) ?: ""
                val image = document.getString(IMAGE_FIELD) ?: ""

                val patapon = Patapon(name, description, image)

                patapons.add(patapon)
            }
            setLista(patapons)
        }
    }
}
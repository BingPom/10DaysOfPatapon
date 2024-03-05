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
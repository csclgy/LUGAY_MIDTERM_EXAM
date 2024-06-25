package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.ttpd_img1),
            Affirmation(R.string.affirmation2, R.drawable.ttpd_img2),
            Affirmation(R.string.affirmation3, R.drawable.ttpd_img3),
            Affirmation(R.string.affirmation4, R.drawable.ttpd_img4),
            Affirmation(R.string.affirmation5, R.drawable.ttpd_img5),
            Affirmation(R.string.affirmation6, R.drawable.ttpd_img6),
            Affirmation(R.string.affirmation7, R.drawable.ttpd_img7),
            Affirmation(R.string.affirmation8, R.drawable.ttpd_img8),
            Affirmation(R.string.affirmation9, R.drawable.ttpd_img9),
            Affirmation(R.string.affirmation10, R.drawable.ttpd_img10))
    }
}

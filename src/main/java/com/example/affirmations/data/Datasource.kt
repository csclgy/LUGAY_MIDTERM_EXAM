package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.t_swift_image1),
            Affirmation(R.string.affirmation2, R.drawable.t_swift_image2),
            Affirmation(R.string.affirmation3, R.drawable.t_swift_image3),
            Affirmation(R.string.affirmation4, R.drawable.t_swift_image4),
            Affirmation(R.string.affirmation5, R.drawable.t_swift_image5),
            Affirmation(R.string.affirmation6, R.drawable.t_swift_image6),
            Affirmation(R.string.affirmation7, R.drawable.t_swift_image7),
            Affirmation(R.string.affirmation8, R.drawable.t_swift_image8),
            Affirmation(R.string.affirmation9, R.drawable.t_swift_image9),
            Affirmation(R.string.affirmation10, R.drawable.t_swift_image10))
    }
}

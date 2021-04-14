package com.serlife.movies.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("image")
fun ImageView.loadImage(image: String?) {
    if (image.isNullOrEmpty()) {
        setImageDrawable(null)
    } else {
        Picasso.get().load(image).into(this)
    }
}
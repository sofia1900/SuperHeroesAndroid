package com.sofia.superHero.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setUrl(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .into(this)
}
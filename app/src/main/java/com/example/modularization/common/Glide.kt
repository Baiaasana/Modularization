package com.example.modularization.common

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.modularization.R
import de.hdodenhof.circleimageview.CircleImageView

class Glide {
    fun setImage(url: String?, image: CircleImageView) {
        Glide
            .with(image.context)
            .load(url)
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop()
            .into(image)
    }
}
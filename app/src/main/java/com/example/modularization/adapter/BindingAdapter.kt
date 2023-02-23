package com.example.modularization.adapter

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.modularization.R
import de.hdodenhof.circleimageview.CircleImageView


@BindingAdapter("android:image")
fun CircleImageView.setImage(url: String?) {
    Glide
        .with(this.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .centerCrop()
        .into(this)
}


@BindingAdapter("intText")
fun AppCompatEditText.setInt(text: Int?) {
    this.setText(text!!.toString())
}


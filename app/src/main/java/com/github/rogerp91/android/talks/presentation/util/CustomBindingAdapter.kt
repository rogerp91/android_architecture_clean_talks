package com.github.rogerp91.android.talks.presentation.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.github.rogerp91.android.talks.R
import com.squareup.picasso.Picasso

/**
 * Created by rpatino on oct/2019
 */
object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:image_url")
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.talks_loading_animation)
            .error(R.drawable.talks_broken_image)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("bind:acceptMercadoPago")
    fun handleBoolean(textView: TextView, it: Boolean) {
        textView.text = when (it) {
            true -> "Acepta Mercado pago"
            else -> "No acepta Mercado Pago"
        }
    }
}
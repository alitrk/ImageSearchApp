package com.codinginflow.imagesearchapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.codinginflow.imagesearchapp.R

fun ImageView.downloadFromUrl(url: String?, context: Context) {
    val options = RequestOptions()
        .error(R.drawable.ic_error)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

@BindingAdapter("android:downloadUrl")
fun downloadImage(view: ImageView, url: String?) {
    view.downloadFromUrl(url, view.context)
}
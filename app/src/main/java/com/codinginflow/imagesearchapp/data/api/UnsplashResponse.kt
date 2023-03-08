package com.codinginflow.imagesearchapp.data.api

import com.codinginflow.imagesearchapp.data.model.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)
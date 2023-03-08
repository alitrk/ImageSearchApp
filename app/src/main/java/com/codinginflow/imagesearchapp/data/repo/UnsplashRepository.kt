package com.codinginflow.imagesearchapp.data.repo

import com.codinginflow.imagesearchapp.data.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
}
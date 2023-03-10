package com.codinginflow.imagesearchapp.data.repo

import androidx.paging.PagingData
import com.codinginflow.imagesearchapp.data.api.UnsplashResponse
import com.codinginflow.imagesearchapp.data.datasource.UnsplashDataSource
import com.codinginflow.imagesearchapp.data.model.UnsplashPhoto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsplashRepository @Inject constructor(private val unsplashDataSource: UnsplashDataSource) {

    fun getSearchResults(query: String): Flow<PagingData<UnsplashPhoto>> = unsplashDataSource.getSearchResults(query)
}
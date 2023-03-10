package com.codinginflow.imagesearchapp.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.codinginflow.imagesearchapp.data.api.UnsplashApi
import com.codinginflow.imagesearchapp.data.pagingsource.UnsplashPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashDataSource @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            )
        , pagingSourceFactory = { UnsplashPagingSource(unsplashApi,query) }
        ).flow
}
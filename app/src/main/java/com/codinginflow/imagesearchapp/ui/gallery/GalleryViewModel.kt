package com.codinginflow.imagesearchapp.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codinginflow.imagesearchapp.data.repo.UnsplashRepository
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest

class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnsplashRepository,
    @Assisted state: SavedStateHandle
)
    : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY,DEFAULT_QUERY)

    val photos = currentQuery.asFlow().flatMapLatest { query ->
        query?.let {
            repository.getSearchResults(query)
        } ?: emptyFlow()
    }.cachedIn(viewModelScope)

    fun searchPhotos(query: String){
        currentQuery.value = query
    }

    companion object{
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "cars"
    }

}
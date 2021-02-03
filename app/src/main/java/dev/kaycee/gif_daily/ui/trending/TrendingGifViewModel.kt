package dev.kaycee.gif_daily.ui.trending

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kaycee.gif_daily.data.remote.api.ApiService
import dev.kaycee.gif_daily.data.repository.DefaultGifRepository
import dev.kaycee.gif_daily.model.State
import dev.kaycee.gif_daily.model.TrendingGif
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class TrendingGifViewModel @ViewModelInject constructor(
    private val repo: DefaultGifRepository
): ViewModel() {

    private val _trendingGifLiveData = MutableLiveData<State<List<TrendingGif>>>()

    val trendingGifLiveData: LiveData<State<List<TrendingGif>>> = _trendingGifLiveData

    fun getTrendingGif() {
        viewModelScope.launch {
            repo.getAllTrendingGif(ApiService.API_KEY)
                .onStart { _trendingGifLiveData.value = State.loading() }
                .map { resource -> State.fromResource(resource) }
                .collect { state -> _trendingGifLiveData.value = state }
        }
    }

}
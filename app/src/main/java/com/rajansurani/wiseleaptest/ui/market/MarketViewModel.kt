package com.rajansurani.wiseleaptest.ui.market

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rajansurani.wiseleaptest.data.model.Market
import com.rajansurani.wiseleaptest.data.repositories.MarketRepository
import com.rajansurani.wiseleaptest.utils.Coroutines
import kotlinx.coroutines.Job

class MarketViewModel (
    private val repository: MarketRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _markets = MutableLiveData<List<Market>>()
    val markets: LiveData<List<Market>>
        get() = _markets

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMarkets() },
            { _markets.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
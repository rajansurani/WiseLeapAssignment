package com.rajansurani.wiseleaptest.ui.market

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajansurani.wiseleaptest.data.repositories.MarketRepository

class MarketViewModelFactory(
    private val repository: MarketRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MarketViewModel(repository) as T
    }

}
package com.rajansurani.wiseleaptest.data.repositories

import com.rajansurani.wiseleaptest.data.network.MarketApi
import com.rajansurani.wiseleaptest.utils.SafeApiRequest

class MarketRepository (
    private val api: MarketApi
    ) : SafeApiRequest() {

        suspend fun getMarkets() = apiRequest { (api.getMarkets()) }.markets
}
package com.rajansurani.wiseleaptest.data.model

data class Market(
    val exchange_id: String,
    val symbol: String,
    val price_unconverted: Double,
    val price: Double,
    val change_24h: Double,
    val spread: Double,
    val volume_24h: Double,
    val status: String,
    val time: String
)
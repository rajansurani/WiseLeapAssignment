package com.rajansurani.wiseleaptest.data.network

import com.rajansurani.wiseleaptest.data.model.Market
import com.rajansurani.wiseleaptest.data.model.MarketResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarketApi {

    @GET("markets")
    suspend fun getMarkets() : Response<MarketResponse>

    companion object{
        operator fun invoke() : MarketApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.cryptingup.com/api/")
                .build()
                .create(MarketApi::class.java)
        }
    }
}
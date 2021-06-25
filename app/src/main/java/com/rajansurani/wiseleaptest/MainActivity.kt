package com.rajansurani.wiseleaptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rajansurani.wiseleaptest.R
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajansurani.wiseleaptest.data.network.MarketApi
import com.rajansurani.wiseleaptest.data.repositories.MarketRepository
import com.rajansurani.wiseleaptest.ui.market.MarketAdapter
import com.rajansurani.wiseleaptest.ui.market.MarketViewModel
import com.rajansurani.wiseleaptest.ui.market.MarketViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var factory: MarketViewModelFactory
    private lateinit var viewModel: MarketViewModel

    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = MarketApi()
        val repository = MarketRepository(api)
        recyclerView = findViewById(R.id.recycler_view_market)

        factory = MarketViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MarketViewModel::class.java)

        viewModel.getMovies()

        viewModel.markets.observe(this, { movies ->
            recyclerView.also {
                            it.layoutManager = LinearLayoutManager(this)
                            it.setHasFixedSize(true)
                            it.adapter = MarketAdapter(movies, this)
                        }
        })

    }
}
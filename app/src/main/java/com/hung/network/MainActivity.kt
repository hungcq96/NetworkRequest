package com.hung.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hung.network.adapter.NewsAdapter
import com.hung.network.databinding.ActivityMainBinding
import com.hung.network.model.News
import com.hung.network.paser.NewsParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val listNews = arrayListOf<News>()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = NewsAdapter(listNews)
        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        lifecycleScope.launch(Dispatchers.IO) {
            listNews.addAll(NewsParser.parserNews("https://cdn.24h.com.vn/upload/rss/trangchu24h.rss"))
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }


    }
}
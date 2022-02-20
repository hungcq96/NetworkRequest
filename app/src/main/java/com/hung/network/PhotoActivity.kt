package com.hung.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hung.network.adapter.PhotoAdapter
import com.hung.network.databinding.ActivityPhotoBinding
import com.hung.network.model.Photo
import com.hung.network.paser.PhotoParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotoBinding
    private val photos = arrayListOf<Photo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPhoto.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val adapter = PhotoAdapter(photos)
        binding.rvPhoto.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) {
            photos.addAll(PhotoParser.getAllPhoto("https://jsonplaceholder.typicode.com/photos"))
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
    }
}
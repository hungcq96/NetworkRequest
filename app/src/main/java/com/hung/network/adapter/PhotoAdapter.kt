package com.hung.network.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hung.network.R
import com.hung.network.databinding.ItemNewsBinding
import com.hung.network.model.News
import com.hung.network.model.Photo

class PhotoAdapter(private val listNews: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            Glide
                .with(binding.imgPreview)
                .load(photo.thumbnailUrl)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(binding.imgPreview)
            binding.tvTitle.text = photo.title
            binding.tvDescription.text = photo.url
            binding.tvDate.text = photo.albumId.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount() = listNews.size
}
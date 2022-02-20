package com.hung.network.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hung.network.databinding.ItemNewsBinding
import com.hung.network.model.News

class NewsAdapter(private val listNews: List<News>) :RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News){
            Glide
                .with(binding.imgPreview)
                .load(news.image)
                .centerCrop()
                .into(binding.imgPreview)
            binding.tvTitle.text = news.title
            binding.tvDescription.text= news.description
            binding.tvDate.text=news.pubDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount() = listNews.size
}
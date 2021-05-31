package com.example.capstone.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.capstone.R
import com.example.capstone.databinding.ItemGridBookBinding

class GridAdapter(private val listBook: ArrayList<Book>) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {
    inner class GridViewHolder(private val binding: ItemGridBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            with(binding){
                Glide.with(itemView.context)
                        .applyDefaultRequestOptions(
                                RequestOptions()
                                        .placeholder(R.color.teal_200)
                        )
                        .load(book.cover)
                        .apply(RequestOptions().override(200, 300))
                        .into(imgGridCover)
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val binding = ItemGridBookBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listBook[position])
    }

    override fun getItemCount(): Int =listBook.size
}
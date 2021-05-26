package com.example.capstone.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.databinding.ItemRowBookBinding

class BookAdapter(private val listBook : ArrayList<Book>) : RecyclerView.Adapter<BookAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class CardViewViewHolder(private val binding: ItemRowBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book){
            with(binding){
                tvItemAuthor.text = book.author
                tvItemGenre.text = book.genre
                tvItemTittle.text = book.title
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.CardViewViewHolder {
        val binding = ItemRowBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holderView: BookAdapter.CardViewViewHolder, position: Int) {
        holderView.bind(listBook[position])
        holderView.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listBook[holderView.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Book)
    }
}
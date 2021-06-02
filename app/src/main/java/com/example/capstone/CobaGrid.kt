package com.example.capstone

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstone.data.Book
import com.example.capstone.data.GridAdapter
import com.example.capstone.databinding.CobaGridBinding

class CobaGrid : AppCompatActivity() {
    private lateinit var binding : CobaGridBinding
    private var listBook : ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CobaGridBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        listBook.addAll(getListCoba())
        showRecyclerGrid()
    }

    private fun showRecyclerGrid() {
        binding.rvCoba.layoutManager = GridLayoutManager(this, 3)
        val gridCobaAdapter = GridAdapter(listBook)
        binding.rvCoba.adapter = gridCobaAdapter
    }

//    fun getListCoba(): ArrayList<Book> {
//        val dataPhoto = resources.getStringArray(R.array.data_photo)
//        val listBook = ArrayList<Book>()
//        for (position in dataPhoto.indices) {
//            val book = Book(
//                    "title",
//                    "author",
//                    "genre",
//                    dataPhoto[position]
//            )
//            listBook.add(book)
//        }
//        return listBook
//    }
}
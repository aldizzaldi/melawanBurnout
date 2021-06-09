package com.example.macapedia.ui.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstone.R
import com.example.capstone.data.Book
import com.example.capstone.data.BookAdapter
import com.example.capstone.databinding.FragmentForYouBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ForYouFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForYouFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listBook : ArrayList<Book> = arrayListOf()
    private lateinit var binding: FragmentForYouBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for_you, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForYouBinding.bind(view)
        binding.rvForYou.setHasFixedSize(true)
        getDataFromAPI()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ForYouFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ForYouFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getDataFromAPI(){
        val client = AsyncHttpClient()
        val url = "http://34.101.254.188/predict"

        client.post(url, object : TextHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?
            ) {
                val result = responseString
                Log.d("hasil", result + "")
                try {
                    val responseObject = JSONObject(result)
                    val titles = responseObject.getJSONArray("titles")
                    val cover = responseObject.getJSONArray("image_urls")
                    for (i in 0 until titles.length()){
                        val book = Book()
                        book.title = titles[i] as String?
                        book.cover = cover[i] as String?
                        listBook.add(book)
                    }
                    showRecycleViewList()

                }catch (e : Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error("eror")}"
                }
                Log.d("hasil", errorMessage)
            }

        })
    }

    private fun showRecycleViewList(){
        binding.rvForYou.layoutManager = LinearLayoutManager(context)
        val listBookAdapter = BookAdapter(listBook)
        binding.rvForYou.adapter = listBookAdapter
    }
}
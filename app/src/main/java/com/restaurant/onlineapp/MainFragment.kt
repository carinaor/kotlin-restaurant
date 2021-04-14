package com.restaurant.onlineapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restaurant.onlineapp.model.Product
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        doAsync {
            var API_URL = "localhost:3000/"
            var API_ENDPOINT = "GetProducts"
            var API_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwiaWF0IjoxNjE4MjgxMDcwLCJleHAiOjE2MTgyODQ2NzB9.U20_JeyjZtbkD_IG44c85kEK58LMrIO5vZDSVgEy-WA"
            val json = URL(API_URL+ API_ENDPOINT +"?token="+API_TOKEN).readText()



            uiThread {
                val products = Gson().fromJson(json, Array<Product>::class.java).toList()

                root.recycler_view.apply {
                    layoutManager = GridLayoutManager(activity, 2)
                    adapter = ProductsAdapter(products)
                    root.progressBar.visibility = View.GONE
                }
            }
        }

        return root
    }
}
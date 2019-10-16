package com.example.classparserecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parse.ParseQuery
import com.parse.ParseObject
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classparserecycler.adapters.AdapterPhoto


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide() //hide the title bar
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_photos_rv)
        val query = ParseQuery.getQuery<ParseObject>("Feed")
        query.findInBackground { objects, _ ->
            recyclerView.adapter = AdapterPhoto(objects)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

}


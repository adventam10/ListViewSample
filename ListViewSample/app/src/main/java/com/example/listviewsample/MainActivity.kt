package com.example.listviewsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.listviewsample.listviews.ArrayAdapterActivity
import com.example.listviewsample.listviews.BaseAdapterActivity
import com.example.listviewsample.listviews.HeaderViewListAdapterActivity
import com.example.listviewsample.listviews.SimpleAdapterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val list = listOf("ArrayAdapter", "BaseAdapter", "SimpleAdapter", "HeaderViewListAdapter")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val text = adapter.getItem(position)
            val intent = when (Menu.valueOf(text!!)) {
                Menu.ArrayAdapter -> Intent(this, ArrayAdapterActivity::class.java)
                Menu.BaseAdapter -> Intent(this, BaseAdapterActivity::class.java)
                Menu.SimpleAdapter -> Intent(this, SimpleAdapterActivity::class.java)
                Menu.HeaderViewListAdapter -> Intent(this, HeaderViewListAdapterActivity::class.java)
            }
            startActivity(intent)
        }
    }
}

enum class Menu {
    ArrayAdapter, BaseAdapter, SimpleAdapter, HeaderViewListAdapter;
}
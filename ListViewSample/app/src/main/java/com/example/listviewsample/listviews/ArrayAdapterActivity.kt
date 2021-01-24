package com.example.listviewsample.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.listviewsample.R

class ArrayAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter)

        val listView1 = findViewById<ListView>(R.id.list1)
        listView1.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            listOf(Hoge("hoge", 1), Hoge("fuga", 2), Hoge("piyo", 3))
        )

        val listView2 = findViewById<ListView>(R.id.list2)
        listView2.adapter = ArrayAdapter<String>(this,
            R.layout.text_row,
            R.id.text,
            listOf("hoge", "fyga", "piyo"))
    }
}

data class Hoge(
    val text: String,
    val num: Int,
)
package com.example.listviewsample.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import com.example.listviewsample.R

class SimpleAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)

        val listView = findViewById<ListView>(R.id.list)
        val list = mutableListOf(
            mutableMapOf(
                "hoge" to Hoge("hoge1", 1),
                "fuga" to Hoge("fuga1", 1),
                "piyo" to Hoge("piyo1", 1)
            ),
            mutableMapOf(
                "hoge" to Hoge("hoge2", 2),
                "fuga" to Hoge("fuga2", 2),
                "piyo" to Hoge("piyo2", 2)
            ),
            mutableMapOf(
                "hoge" to Hoge("hoge3", 3),
                "fuga" to Hoge("fuga3", 3),
                "piyo" to Hoge("piyo3", 3)
            )
        )
        val adapter = SimpleAdapter(this, list,
            R.layout.simple_text_row,
            arrayOf("hoge", "fuga", "piyo"),
            arrayOf(R.id.text1, R.id.text2, R.id.text3).toIntArray()
        )
        listView.adapter = adapter
    }
}
package com.example.listviewsample.listviews

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewsample.R


class HeaderViewListAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header_view_list_adapter)

        val listView = findViewById<ListView>(R.id.list)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf(Hoge("hoge", 1), Hoge("fuga", 2), Hoge("piyo", 3))
        )
        listView.adapter = adapter
        val header1 = TextView(this).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100
            )
            this.setBackgroundColor(getColor(R.color.purple_200))
            this.setTextColor(getColor(R.color.white))
            this.text = "Header1"
        }
        listView.addHeaderView(header1)

        val header2 = TextView(this).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100
            )
            this.setBackgroundColor(getColor(R.color.purple_500))
            this.setTextColor(getColor(R.color.white))
            this.text = "Header2"
        }
        listView.addHeaderView(header2)

        val footer1 = TextView(this).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100
            )
            this.setBackgroundColor(getColor(R.color.purple_200))
            this.setTextColor(getColor(R.color.white))
            this.text = "Footer1"
        }
        listView.addFooterView(footer1)

        val footer2 = TextView(this).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100
            )
            this.setBackgroundColor(getColor(R.color.purple_500))
            this.setTextColor(getColor(R.color.white))
            this.text = "Footer2"
        }
        listView.addFooterView(footer2)
    }
}
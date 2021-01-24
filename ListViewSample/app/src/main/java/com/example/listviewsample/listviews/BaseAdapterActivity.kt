package com.example.listviewsample.listviews

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import com.example.listviewsample.R

class BaseAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_adapter)
        val adapter = CustomAdapter(
            this,
            listOf(Hoge("hoge", 1), Hoge("fuga", 2), Hoge("piyo", 3))
        )
        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = adapter
    }
}

class CustomAdapter(context: Context,
                    private val items: List<Hoge>) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun getCount() = items.size

    override fun getItem(position: Int) = items[position]

    // 一覧内で一意になるやつ
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: createView(parent)
        val item = getItem(position)
        val viewHolder = view.tag as ViewHolder
        viewHolder.text.text = item.text
        viewHolder.checkBox.isChecked = item.num % 2 == 0
        return view
    }

    private fun createView(parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.custom_row, parent, false)
        view.tag = ViewHolder(view)
        return view
    }

    private class ViewHolder(view: View) {
        val text = view.findViewById<TextView>(R.id.text)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBox)
    }
}


package ru.demchuk.snc.view

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import ru.demchuk.snc.R


class ListProduct : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)
        val intent = intent
        val listProductDate = intent.getStringArrayListExtra("products") as ArrayList<String>
        val listView = findViewById<ListView>(R.id.listProductView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listProductDate)
        listView.adapter = adapter
    }
}
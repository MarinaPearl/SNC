package ru.demchuk.snc.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import ru.demchuk.snc.R

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickStart(view: View) {
        val intent = Intent(this, ChoosingCategory::class.java)
        startActivity(intent)
    }
}
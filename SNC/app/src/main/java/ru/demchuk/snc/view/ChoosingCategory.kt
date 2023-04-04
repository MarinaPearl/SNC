package ru.demchuk.snc.view


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import ru.demchuk.snc.R


class ChoosingCategory : Activity(), OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_category)
    }

    override fun onResume() {
        super.onResume()
        val hairButton = findViewById<Button>(R.id.hair)
        hairButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.hair -> {
                val intent = Intent(this, Hair::class.java)
                startActivity(intent)
            }
        }
    }
}
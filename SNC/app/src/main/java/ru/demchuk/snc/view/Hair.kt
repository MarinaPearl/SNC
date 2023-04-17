package ru.demchuk.snc.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.lifecycle.Observer
import ru.demchuk.snc.R
import ru.demchuk.snc.vm.ConnectionWithModelDb


class Hair : Activity() {

    private var listAnswer = ArrayList<String>()
    private var vm = ConnectionWithModelDb()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hair)
    }

    override fun onResume() {
        super.onResume()
        val radioGroupCurls = findViewById<RadioGroup>(R.id.radioGroupСurls)
        val radioGroupDandruff = findViewById<RadioGroup>(R.id.radioGroupDandruff)
        val radioGroupDescription = findViewById<RadioGroup>(R.id.radioGroupDescription)
        val radioGroupLoss = findViewById<RadioGroup>(R.id.radioGroupLoss)

        radioGroupCurls.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                //listAnswer.add(text.toString())
            }
        }
        radioGroupDandruff.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                //listAnswer.add(text.toString())
            }
        }
        radioGroupDescription.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                listAnswer.add(text.toString())
            }
        }
        radioGroupLoss.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                //listAnswer.add(text.toString())
            }
        }
        try {
            listAnswer.add("gggg")
            val observer = Observer<ArrayList<String>> {
                runOnUiThread {
                    val intent = Intent(this, ListProduct::class.java)
                    intent.putStringArrayListExtra("products", it)
                    startActivity(intent)
                }
            }
            vm.liveData.observeForever(observer)
        }catch (error : Exception) {
            println(error.toString())
        }
    }

    fun onClickRequestDb(view: View) {
        vm.requestProductFromDatabase(listAnswer)
    }
}

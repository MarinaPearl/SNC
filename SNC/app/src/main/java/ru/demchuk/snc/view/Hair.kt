package ru.demchuk.snc.view

import android.app.Activity
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
                listAnswer.add(text.toString())
            }
        }
        radioGroupDandruff.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                listAnswer.add(text.toString())
            }
        }
        radioGroupDescription.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                listAnswer.add(text.toString())
            }
        }
        radioGroupLoss.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                listAnswer.add(text.toString())
            }
        }

//        val observer = Observer<ArrayList<String>> {
//            runOnUiThread {
//                Log.d("aaaaaaaaaaaaaaaa", it.toString())
//            }
//        }
//        vm.liveData.observeForever(observer)
    }

    fun onClickRequestDb(view: View) {
        //Log.d("ddddddddddddddd", listAnswer.toString())
        vm.requestProductFromDatabase(listAnswer)
    }
}

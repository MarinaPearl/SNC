package ru.demchuk.snc.model

import android.util.Log
import ru.demchuk.snc.vm.ConnectionWithModelDb

class WorkerWithDb(private val listSelector : ArrayList<String>, private val viewModel : ConnectionWithModelDb) {

    private var liseAnswerInModel = ArrayList<String>()

     fun workWithSelect() {
         Log.d("zzzzzzzzzz", listSelector.toString())
         try {
              Thread {
                 val databaseHandler = DatabaseHandler().getDbConnection()
                  Log.d("zzzzzzzzzz","nnnnnnnnnnnnnnnn")
                 //val workerWithDb = RequesterInDb(databaseHandler)
                 //liseAnswerInModel = workerWithDb.selectInDb(listSelector)
                 //returnDateInViewModel()
             }.start()
         }catch (error :Exception) {
             Log.d("bbbbbbbbbbb", error.toString())
         }
     }

    private fun returnDateInViewModel() {
            viewModel.receiveListOutView(liseAnswerInModel)
    }
}

fun main() {
    try {
        val databaseHandler = DatabaseHandler().getDbConnection()
        val workerWithDb = RequesterInDb(databaseHandler)
        println("eeeeeeeeeeeeeee")
    }catch (error : Exception) {
        println(error.toString())
        Log.d("kkkkkkb", error.toString())
    }
}
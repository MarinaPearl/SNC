package ru.demchuk.snc.vm

import androidx.lifecycle.MutableLiveData
import ru.demchuk.snc.model.RequesterInDb
import ru.demchuk.snc.model.WorkerWithDb

class ConnectionWithModelDb {

    val liveData = MutableLiveData<ArrayList<String>>()

    fun requestProductFromDatabase(listWithInformationFromUser: ArrayList<String>) {
        val workerWithDb = WorkerWithDb(listWithInformationFromUser, this)
        workerWithDb.workWithSelect()

    }

    fun receiveListOutView(listAnswer: ArrayList<String>) {
            liveData.postValue(listAnswer)
    }
}
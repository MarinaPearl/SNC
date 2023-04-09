package ru.demchuk.snc.model

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class RequesterInDb(private val databaseHandler: Connection) {

    private var listSelect = ArrayList<String>()

    fun selectInDb(listSelector: ArrayList<String>): ArrayList<String> {
        val statement: Statement = databaseHandler.createStatement()
        val splitArrayList = splitStrings(listSelector)
        for (i in 0 until  splitArrayList[0].size) {
            val result: ResultSet =
                statement.executeQuery("select * from beautyandhealth.shampoo where description like '%${splitArrayList[0][i]}%' or shortDescription like '%${splitArrayList[0][i]}%'")
            while (result.next()) {
                print(result.getString(2) + "; ")
                print(result.getString(3) + "; ")
                print(result.getString(4) + "; ")
                println(result.getString(5) + "; ")
                listSelect.add(result.getString(2) + "; ")
                listSelect.add(result.getString(3) + "; ")
                listSelect.add(result.getString(4) + "; ")
                listSelect.add(result.getString(5) + "; ")
            }
        }
        return listSelect
    }

    private fun splitStrings(listNeedSplit: ArrayList<String>) : ArrayList<ArrayList<String>> {
        val splitArrayList = ArrayList<ArrayList<String>>()
        listNeedSplit.forEach {
            splitArrayList.add(it.split(" ") as ArrayList<String>)
        }
        return splitArrayList
    }
}

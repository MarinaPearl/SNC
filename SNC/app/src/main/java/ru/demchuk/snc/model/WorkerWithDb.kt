package ru.demchuk.snc.model

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class WorkerWithDb(private val databaseHandler: Connection) {

    private var listSelect = ArrayList<String>()

    fun selectInDb() {
        val statementEyeCream: Statement = databaseHandler.createStatement()
        val resultSetEyeCream: ResultSet =
            statementEyeCream.executeQuery("select * from beautyandhealth.eyecream where description like '%Омолаживающий%' or shortDescription like '%Омолаживающий%'")
        while (resultSetEyeCream.next()) {
            print(resultSetEyeCream.getString(2) + "; ")
            print(resultSetEyeCream.getString(3) + "; ")
            print(resultSetEyeCream.getString(4) + "; ")
            println(resultSetEyeCream.getString(5) + "; ")
        }
    }
}
package ru.demchuk.snc.model

import android.os.AsyncTask
import android.util.Log
import ru.demchuk.snc.vm.ConnectionWithModelDb
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread


class WorkerWithDb(
    val viewModel: ConnectionWithModelDb
) {

    private var listAnswerInModel = ArrayList<String>()

    fun workWithSelect() {
            Class.forName("oracle.jdbc.driver.OracleDriver")
            val dbURL = "jdbc:oracle:thin:@84.237.50.81:1521:XE"
            thread {
                try {
                    // Locale.setDefault(Locale.ENGLISH);
                    val myConnection: Connection =
                        DriverManager.getConnection(dbURL, "", "")
                    val myQuery: Statement = myConnection.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                    )
                    val s = myQuery.executeQuery("select * from SHAMPOO_H")
                    while (s.next()) {
                        listAnswerInModel.add(s.getString(2) + "; " + "\n" + s.getString(3) + "; ")
                        //listAnswerInModel.add(s.getString(3) + "; ")
                    }
                    myConnection.close()
                    viewModel.receiveListOutView(listAnswerInModel)
                } catch (error: Exception) {
                    Log.d("Error in select", error.toString())
                }
            }
        }
}




package ru.demchuk.snc.model

import ru.demchuk.snc.model.Configs.dbHost
import ru.demchuk.snc.model.Configs.dbName
import ru.demchuk.snc.model.Configs.dbPass
import ru.demchuk.snc.model.Configs.dbPort
import ru.demchuk.snc.model.Configs.dbUser
import ru.demchuk.snc.model.ConstForDb.BRAND
import ru.demchuk.snc.model.ConstForDb.DESCRIPTION
import ru.demchuk.snc.model.ConstForDb.EYE_CREAM_TABLE
import ru.demchuk.snc.model.ConstForDb.HAND_CREAM_TABLE
import ru.demchuk.snc.model.ConstForDb.PRICE
import ru.demchuk.snc.model.ConstForDb.SHAMPOO_TABLE
import ru.demchuk.snc.model.ConstForDb.SHORT_DESCRIPTION
import ru.demchuk.snc.model.ConstForDb.VOLUME
import java.sql.Connection
import java.sql.DriverManager


class DatabaseHandler {


    @JvmName("getDbConnection1")
    fun getDbConnection(): Connection {
        val connectionString = "jdbc:mysql://$dbHost" + ":" +
                dbPort + "/" + dbName
        //Class.forName("com.mysql.cj.jdbc.Driver")
        return DriverManager.getConnection(
            connectionString,
            dbUser, dbPass
        )
    }

    fun insertProduct(
        brand: String?,
        shortDescription: String?,
        volume: String?,
        price: Int,
        description: String?,
        key: Int
    ) {
        var table: String? = null
        when (key) {
            0 -> table = EYE_CREAM_TABLE
            1 -> table = HAND_CREAM_TABLE
            2 -> table = SHAMPOO_TABLE
        }
        val insert = "INSERT INTO " + table + "(" + BRAND +
                "," + SHORT_DESCRIPTION + "," + VOLUME + "," +
                PRICE + "," + DESCRIPTION + ")" +
                "VALUES(?,?,?,?,?)"
        val prSt = getDbConnection().prepareStatement(insert)
        prSt.setString(1, brand)
        prSt.setString(2, shortDescription)
        prSt.setString(3, volume)
        prSt.setInt(4, price)
        prSt.setString(5, description)
        prSt.executeUpdate()
    }
}

package ru.demchuk.snc.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.demchuk.snc.presentation.model.Product

interface HairApi {

    @GET("diplom_1/")
    suspend fun getAllProductForHair(): List<Product>

    @GET("getProductWithCondition")
    suspend fun getProductWithCondition(@Query("condition") condition : String) : List<Product>

    @GET("getSetsHair")
    suspend fun getSets(@Query("brand") brand : String, @Query("name") name : String) : List<Product>
}
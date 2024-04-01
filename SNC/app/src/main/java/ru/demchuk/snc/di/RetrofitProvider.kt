package ru.demchuk.snc.di

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.demchuk.snc.data.HairApi

class RetrofitProvider {
    private val api: HairApi by lazy {
        retrofit.create(HairApi::class.java)
    }

    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl("http://192.168.0.116:8111/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    fun get(): HairApi = api
}
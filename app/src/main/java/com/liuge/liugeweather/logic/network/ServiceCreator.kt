package com.liuge.liugeweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * FileName: ServiceCreator
 * Author: LiuGe
 * Date: 2020/8/9 19:04
 * Description: Retrofit构建器
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> create(serviceClass: Class<T>) :T = retrofit.create(serviceClass)
    inline fun <reified T> create():T = create(T::class.java)
}
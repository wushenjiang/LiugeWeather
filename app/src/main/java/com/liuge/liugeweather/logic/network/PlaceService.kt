package com.liuge.liugeweather.logic.network

import com.liuge.liugeweather.LiugeWeatherApplication
import com.liuge.liugeweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * FileName: PlaceService
 * Author: LiuGe
 * Date: 2020/8/9 19:02
 * Description: 地区API
 */
interface PlaceService{
    @GET("v2/place?token=${LiugeWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String): Call<PlaceResponse>
}
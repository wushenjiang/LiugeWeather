package com.liuge.liugeweather.logic.network

import com.liuge.liugeweather.LiugeWeatherApplication
import com.liuge.liugeweather.logic.model.DailyResponse
import com.liuge.liugeweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * FileName: WeatherService
 * Author: LiuGe
 * Date: 2020/8/10 16:23
 * Description: 天气接口
 */
interface WeatherService {
    @GET("v2.5/${LiugeWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng:String,@Path("lat") lat:String): Call<RealtimeResponse>
    @GET("v2.5/${LiugeWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng:String,@Path("lat") lat: String):Call<DailyResponse>
}
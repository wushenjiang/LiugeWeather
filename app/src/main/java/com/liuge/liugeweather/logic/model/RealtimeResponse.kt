package com.liuge.liugeweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * FileName: RealtimeResponse
 * Author: LiuGe
 * Date: 2020/8/10 16:15
 * Description: 实时天气model
 */
data class RealtimeResponse(val status:String,val result:Result){
    data class Result(val realtime:Realtime)
    data class Realtime(val skycon:String,val temperature:Float,@SerializedName("air_quality") val airQuality:AirQuality)
    data class AirQuality(val aqi:AQI)
    data class AQI(val chn:Float)
}
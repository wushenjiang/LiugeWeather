package com.liuge.liugeweather.logic.model

/**
 * FileName: Weather
 * Author: LiuGe
 * Date: 2020/8/10 16:22
 * Description: 天气model
 */
data class Weather(val realtime:RealtimeResponse.Realtime,val daily:DailyResponse.Daily)
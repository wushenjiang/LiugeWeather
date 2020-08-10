package com.liuge.liugeweather.logic.dao

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.liuge.liugeweather.LiugeWeatherApplication
import com.liuge.liugeweather.logic.model.Place
import com.liuge.liugeweather.logic.network.LiugeWeatherNetwork

/**
 * FileName: PlaceDao
 * Author: LiuGe
 * Date: 2020/8/10 17:45
 * Description: 存储sharedpreferences
 */
object PlaceDao {
    fun savePlace(place:Place){
       sharedPreferences().edit(){
           putString("place",Gson().toJson(place))
       }
    }
    fun getSavedPlace():Place{
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }
    fun isPlaceSaved() = sharedPreferences().contains("place")
    private fun sharedPreferences() = LiugeWeatherApplication.context.getSharedPreferences("liuge_weather",
        Context.MODE_PRIVATE)
}
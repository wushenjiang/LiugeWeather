package com.liuge.liugeweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.liuge.liugeweather.logic.Repository
import com.liuge.liugeweather.logic.model.Location

/**
 * FileName: WeatherViewModel
 * Author: LiuGe
 * Date: 2020/8/10 16:43
 * Description: 天气的viewmodel
 */
class WeatherViewModel:ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLiveData = Transformations.switchMap(locationLiveData){location ->
        Repository.refreshWeather(location.lng,location.lat)
    }
    fun refreshWeather(lng:String,lat:String){
        locationLiveData.value = Location(lng,lat)
    }
}
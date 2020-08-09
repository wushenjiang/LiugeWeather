package com.liuge.liugeweather.logic

import androidx.lifecycle.liveData
import com.liuge.liugeweather.logic.model.Place
import com.liuge.liugeweather.logic.network.LiugeWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/**
 * FileName: Repository
 * Author: LiuGe
 * Date: 2020/8/9 19:15
 * Description: 仓库层的统一封装入口
 */
object Repository {
    // liveData是ktx库提供的一个功能，可以自动构建并返回LiveData对象
    // 可以在代码块提供一个挂起函数的上下文，并将线程设置成了IO，所有的代码块都在子线程中了。
    //
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = LiugeWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                // 请求成功，读取数据并返回
                val places = placeResponse.places
                Result.success(places)
            } else {
                // 请求失败，数据为空，把错误信息包装抛上层
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            //请求失败，把错误信息抛出去
            Result.failure<List<Place>>(e)
        }
        // 将liveData发射出去
        emit(result)
    }
}
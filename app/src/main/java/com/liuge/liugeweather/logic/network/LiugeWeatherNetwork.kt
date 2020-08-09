package com.liuge.liugeweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * FileName: LiugeWeatherNetwork
 * Author: LiuGe
 * Date: 2020/8/9 19:08
 * Description: 封装API
 */
object LiugeWeatherNetwork {
    private val placeService = ServiceCreator.create(PlaceService::class.java)
    // suspend,协程 这里对所有Call<T>定义了一个扩展方法await,里面对数据进行了处理和封装
    //
    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()

    /**
     * 使用协程的写法来简化Retrofit回调
     */
    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {
            continuation -> enqueue(object :Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if(body != null){
                    // 请求成功，继续
                    continuation.resume(body)
                }else{
                    // 请求成功但无结果，继续
                    continuation.resumeWithException(RuntimeException("response body is null"))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                // 请求失败，返回错误信息
                continuation.resumeWithException(t)
            }
        })
        }
    }
}
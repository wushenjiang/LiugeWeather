package com.liuge.liugeweather

import android.app.Application
import android.content.Context

/**
 * FileName: LiugeWeatherApplication
 * Author: LiuGe
 * Date: 2020/8/9 18:59
 * Description: 全局类
 */
class LiugeWeatherApplication:Application() {
    companion object{
        const val TOKEN = "0Id8aRHvCNACQeNF"
         lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}
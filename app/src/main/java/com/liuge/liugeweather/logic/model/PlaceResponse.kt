package com.liuge.liugeweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * FileName: PlaceResponse
 * Author: LiuGe
 * Date: 2020/8/9 19:01
 * Description: 全球城市数据模型
 */
data class PlaceResponse(val status:String,val places:List<Place>)
data class Place(val name:String,val location:Location,@SerializedName("formatted_address") val address:String)
data class Location(val lng:String,val lat:String)
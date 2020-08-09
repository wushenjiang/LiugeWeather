package com.liuge.liugeweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.liuge.liugeweather.R
import com.liuge.liugeweather.logic.model.Place
import kotlinx.android.synthetic.main.item_place.view.*

/**
 * FileName: PlaceAdapter
 * Author: LiuGe
 * Date: 2020/8/9 21:12
 * Description: place的适配器
 */
class PlaceAdapter(private val fragment:Fragment,private val placeList: List<Place>):
    RecyclerView.Adapter<PlaceAdapter.InnerHolder>() {
    inner class InnerHolder(view:View):RecyclerView.ViewHolder(view) {
        val placeName:TextView = view.findViewById(R.id.placeName)
        val placeAddress:TextView  = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.InnerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place,parent,false)
        return InnerHolder(view)
    }

    override fun getItemCount() = placeList.size

    override fun onBindViewHolder(holder: PlaceAdapter.InnerHolder, position: Int) {
        val place = placeList[position]
        holder.placeAddress.text = place.address
        holder.placeName.text = place.name
    }
}
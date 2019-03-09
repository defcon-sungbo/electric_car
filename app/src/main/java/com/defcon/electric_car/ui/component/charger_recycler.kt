package com.defcon.electric_car.ui.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.defcon.electric_car.R
import com.defcon.electric_car.model.ChargerModel

class ChargerRecyclerAdapter : RecyclerView.Adapter<ChargerRecyclerAdapter.VH>() {
    var cardRes : Int = R.layout.card_charger;
    var data : MutableList<ChargerModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(cardRes, parent, false)
        return VH(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {

    }

    class VH(v : View) : RecyclerView.ViewHolder(v) {

    }

}
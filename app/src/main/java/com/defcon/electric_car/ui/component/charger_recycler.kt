package com.defcon.electric_car.ui.component

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.defcon.electric_car.R
import com.defcon.electric_car.model.ChargerModel
import com.defcon.electric_car.model.NearByModel
import com.defcon.electric_car.ui.main.charger_detail.ChargerDetialActivity


class ChargerRecyclerAdapter(
    val context: Context
) : RecyclerView.Adapter<ChargerRecyclerAdapter.VH>() {
    var cardRes : Int = com.defcon.electric_car.R.layout.card_charger;
    var data : MutableList<ChargerModel> = mutableListOf()
    var onClickListner :  (ChargerModel) -> Unit = {item -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(cardRes, parent, false)

        return VH(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position], onClickListner)
    }

    class VH(v : View) : RecyclerView.ViewHolder(v) {

        fun bind(item: ChargerModel, listener: (ChargerModel) -> Unit) = with(itemView) {
            setOnClickListener {
                listener.invoke(item)
            }
        }
    }

}


class NearRecyclerAdapter(
    val context: Context
) : RecyclerView.Adapter<NearRecyclerAdapter.VH>() {
    var cardRes : Int = com.defcon.electric_car.R.layout.card_near;
    var data : MutableList<NearByModel> = mutableListOf()
    var onClickListner :  (NearByModel) -> Unit = {item -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(cardRes, parent, false)

        return VH(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position], onClickListner)
    }

    class VH(v : View) : RecyclerView.ViewHolder(v) {

        fun bind(item: NearByModel, listener: (NearByModel) -> Unit) = with(itemView) {
            setOnClickListener {
                listener.invoke(item)
            }
            Glide
                .with(
                    context
                )
                .load(item.img[0])
                .into(findViewById<ImageView>(R.id.roundedImageView));

            findViewById<AppCompatTextView>(R.id.appCompatTextView4).setText(item.Name)
            findViewById<AppCompatTextView>(R.id.subtitle).setText(item.Name)

        }
    }

}
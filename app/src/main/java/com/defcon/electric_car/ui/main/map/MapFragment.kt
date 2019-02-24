package com.defcon.electric_car.ui.main.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.defcon.electric_car.R
import com.defcon.electric_car.ui.main.bottom.BottomFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MapFragment : Fragment() {

    companion object {
        fun newInstance() = MapFragment()
        var instance: MapFragment? = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_map, container, false)
        instance = this
        return v
    }
}
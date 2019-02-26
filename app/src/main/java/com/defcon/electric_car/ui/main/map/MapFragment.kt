package com.defcon.electric_car.ui.main.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.*


class MapFragment : Fragment() {
    companion object {
        fun newInstance() = MapFragment()
        var instance: MapFragment? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(
            com.defcon.electric_car.R.layout.fragment_map, container,
            false
        )
        val mMapView = v.findViewById(com.defcon.electric_car.R.id.mapView) as MapView
        mMapView.onCreate(savedInstanceState)

        mMapView.onResume()

        try {
            MapsInitializer.initialize(activity!!.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return v
    }
}
package com.defcon.electric_car.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.defcon.electric_car.R
import com.defcon.electric_car.ui.main.bottom.BottomFragment
import com.defcon.electric_car.ui.main.map.MapFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMap()
        initMainBottom()


    }

    private fun initMap() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_map_container, MapFragment.newInstance())
            .commitNow()
    }

    private fun initMainBottom() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main_bottom, BottomFragment.newInstance())
            .commitNow()
    }

}

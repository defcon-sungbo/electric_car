package com.defcon.electric_car.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.defcon.electric_car.GotoActivity
import com.defcon.electric_car.R
import com.defcon.electric_car.ui.main.bottom.BottomFragment
import com.defcon.electric_car.ui.main.map.MapFragment
import com.defcon.electric_car.ui.main.setting.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMap()
        initMainBottom()
        initButton()
    }

    private fun initButton() {
        setting.setOnClickListener {
            GotoActivity(SettingsActivity::class.java)
        }
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

package com.defcon.electric_car.ui.main.near_detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.defcon.electric_car.R
import com.defcon.electric_car.model.NearByModel

class NearDetailActivity : AppCompatActivity() {


    companion object {
        var data : NearByModel? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_near_detail)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NearDetailFragment.newInstance(data!!))
                .commitNow()
        }
    }
}

package com.defcon.electric_car.ui.main.charger_detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.defcon.electric_car.GotoActivity
import com.defcon.electric_car.R
import com.defcon.electric_car.model.ChargerModel
import com.defcon.electric_car.model.NearByModel
import com.defcon.electric_car.model.dummy
import com.defcon.electric_car.ui.component.NearRecyclerAdapter
import com.defcon.electric_car.ui.main.near_detail.NearDetailActivity
import com.defcon.electric_car.ui.main.near_detail.NearDetailFragment
import kotlinx.android.synthetic.main.activity_charger_detail.*
import kotlinx.android.synthetic.main.fragment_default_bottom.*

class ChargerDetialActivity : AppCompatActivity() {


    companion object {
        var data : ChargerModel? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charger_detail)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ChargerDetailFragment.newInstance(data!!))
                .commitNow()
        }
    }
}

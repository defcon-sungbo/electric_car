package com.defcon.electric_car.ui.main.charger_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.defcon.electric_car.R
import com.defcon.electric_car.model.NearByModel
import com.defcon.electric_car.model.dummy
import com.defcon.electric_car.ui.component.NearRecyclerAdapter
import kotlinx.android.synthetic.main.activity_charger_detail.*
import kotlinx.android.synthetic.main.fragment_default_bottom.*

class ChargerDetialActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charger_detail)

        var lm =  LinearLayoutManager(this);
        lm.orientation = RecyclerView.HORIZONTAL;
        near.layoutManager = lm;
        near.adapter = NearRecyclerAdapter(this).apply {
            data = dummy.dummy_nearBy
        }
    }


}

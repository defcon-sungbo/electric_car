package com.defcon.electric_car.ui.main.bottom.default_state

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.defcon.electric_car.GotoActivity
import com.defcon.electric_car.R
import com.defcon.electric_car.model.ChargerModel
import com.defcon.electric_car.ui.component.ChargerRecyclerAdapter
import com.defcon.electric_car.ui.main.charger_detail.ChargerDetialActivity
import kotlinx.android.synthetic.main.fragment_default_bottom.*

class DefaultBottomFragment : Fragment() {

    companion object {
        fun newInstance() = DefaultBottomFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_default_bottom, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    fun initRecycler() {

        var lm =  LinearLayoutManager(context);
        lm.orientation = RecyclerView.VERTICAL;
        recycler.layoutManager = lm;
        recycler.adapter = ChargerRecyclerAdapter(context = this!!.context!!).apply {
            data = mutableListOf(ChargerModel(0.0,0.0,"",""),ChargerModel(0.0,0.0,"",""))
            onClickListner = {chargerModel ->
//                    var intent = Intent(this@DefaultBottomFragment.activity, ChargerDetialActivity::class.java);
//                    this@DefaultBottomFragment.activity!!.startActivity(intent)
//                    ChargerDetialActivity.data = chargerModel
                GotoActivity(ChargerDetialActivity::class.java, {ChargerDetialActivity.data = chargerModel})
            }
        }


    }
}
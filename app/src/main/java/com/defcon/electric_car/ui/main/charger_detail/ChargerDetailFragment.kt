package com.defcon.electric_car.ui.main.charger_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.defcon.electric_car.GotoActivity

import com.defcon.electric_car.R
import com.defcon.electric_car.model.ChargerModel
import com.defcon.electric_car.model.NearByModel
import com.defcon.electric_car.model.dummy
import com.defcon.electric_car.ui.component.NearRecyclerAdapter
import com.defcon.electric_car.ui.main.near_detail.NearDetailActivity
import kotlinx.android.synthetic.main.fragment_charger_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class ChargerDetailFragment : Fragment() {
    lateinit var data : ChargerModel
    companion object {
        fun newInstance(m:ChargerModel) = ChargerDetailFragment().apply { data = m }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charger_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding()
    }

    private fun binding() {
        var lm =  LinearLayoutManager(context);
        lm.orientation = RecyclerView.HORIZONTAL;
        near.layoutManager = lm;
        near.adapter = NearRecyclerAdapter(context!!).apply {
            data = dummy.dummy_nearBy
            onClickListner = {model: NearByModel ->
                GotoActivity(NearDetailActivity::class.java, { NearDetailActivity.data = model}) }
        }
    }

}

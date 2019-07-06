package com.defcon.electric_car.ui.main.near_detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.defcon.electric_car.R
import com.defcon.electric_car.model.NearByModel
import kotlinx.android.synthetic.main.fragment_near_detail.*

// TODO: Rename parameter arguments, choose names that match
class NearDetailFragment : Fragment() {
    lateinit var data : NearByModel
    companion object {
        fun newInstance(nearByModel: NearByModel) = NearDetailFragment().apply { data = nearByModel }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_near_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding()
    }

    private fun binding() {
        nearName.text = data.Name

    }


}

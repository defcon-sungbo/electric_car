package com.defcon.electric_car.ui.main.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.defcon.electric_car.R
import com.defcon.electric_car.ui.main.bottom.default_state.DefaultBottomFragment
import com.defcon.electric_car.ui.main.bottom.pin_selected_state.OnPinSelectedFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.makeramen.roundedimageview.Corner
import kotlinx.android.synthetic.main.fragment_main_bottom.*

class BottomFragment : Fragment() {

    companion object {
        fun newInstance() = BottomFragment()
        var instance: BottomFragment? = null
    }

    lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_main_bottom, container, false)
        instance = this
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeBottomView(BottomViewState.Default)
        initSlideAnimation()
        bindView()
    }

    private fun changeBottomView(viewState: BottomViewState, selectedItem : Any? = null ) {
        //TODO:: ADD DATA;;
        when(viewState){
            BottomViewState.Default -> {  setDefaultBottomStateView() }
            BottomViewState.PinSelected -> { setSelectedBottomStateView()}
        }
    }

    fun setDefaultBottomStateView() {
        fragmentManager!!.beginTransaction()
            .replace(R.id.container_bottom_fragment, DefaultBottomFragment.newInstance())
            .commit()
    }
    fun setSelectedBottomStateView() {
        fragmentManager!!.beginTransaction()
            .replace(R.id.container_bottom_fragment, OnPinSelectedFragment.newInstance())
            .commit()
    }


    internal fun initSlideAnimation() {
        bottomSheetBehavior = BottomSheetBehavior.from(dragView as View)
        var defaltRadius = background.getCornerRadius(Corner.TOP_RIGHT)
        var defaultPadding = dragView.paddingLeft

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(p0: View, p1: Int) {

            }

            override fun onSlide(p0: View, slideOffset: Float) {
                var radiusVal = (1 - slideOffset) * defaltRadius
                background.setCornerRadius(radiusVal, radiusVal, 0f, 0f)
                dragView.setPadding(
                    (defaultPadding * (1 - slideOffset)).toInt(),
                    0,
                    (defaultPadding * (1 - slideOffset)).toInt(),
                    0
                )
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

    fun bindView() {

    }
}

enum class BottomViewState {
    Default,
    PinSelected,

}

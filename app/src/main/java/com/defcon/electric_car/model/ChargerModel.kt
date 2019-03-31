package com.defcon.electric_car.model

import android.location.Location

data class ChargerModel(var lat : Double , var lon : Double,
                        var Name : String, var info : String){
//    val geopoint
//        get() =
    fun location(): Location {
        var a = Location("")
        a.longitude = this. lon
        a.latitude = this. lat
        return a;
    }
    fun near(){

    }

}

data class NearByModel(var lat : Double , var lon : Double,
                        var Name : String, var img : List<String>){
    fun location(): Location {
        var a = Location("")
        a.longitude = this. lon
        a.latitude = this. lat
        return a;
    }


}
package com.defcon.electric_car

import android.Manifest
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.media.RingtoneManager
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*


fun AppCompatActivity.Toast(str : String) {
    android.widget.Toast.makeText(applicationContext, str, android.widget.Toast.LENGTH_LONG).show()
}

fun Fragment.Toast(str : String) {
    android.widget.Toast.makeText(this.context!!.applicationContext, str, android.widget.Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.GotoActivity(cls: Class<*>, @Nullable subscription: () -> Unit)  { var intent = Intent(this, cls)
    GotoActivity(cls)
    subscription()
}
fun AppCompatActivity.GotoActivity(cls: Class<*>)  { var intent = Intent(this, cls)
    this.startActivity(intent)
}
//fun GeoPoint.toAddress(): String {
//    val geoCoder = Geocoder(RydeApplication.context, Locale.KOREAN);
//    var Area = "";
//
//    try {
//        var addresses : List<Address>  = geoCoder.getFromLocation(latitude, longitude, 5)
//        if (addresses.size > 0) {
//            var mAddress = addresses.get(0);
//
//            Area = "${mAddress.adminArea} ${mAddress.locality}  ${mAddress.thoroughfare}"
//
//            return Area;
//        }
//    } catch (e:Exception) {
//        e.printStackTrace();
//    }
//    return "Error";
//
//
//}

fun Date.toHHmm(): String? {
    val transFormat = SimpleDateFormat("HH:mm");
    return transFormat.format(this);
}
fun Date.toYYMMDD(): String? {
    val transFormat = SimpleDateFormat("YYYY.HH.mm");
    return transFormat.format(this);
}

//fun Fragment.InitAppbar() {
//    try {
//        // region
//        val container_app_bar_layout = activity!!.findViewById<ViewGroup>(R.id.container_app_bar_layout)
//        val toolbar = container_app_bar_layout.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
//        val activity = activity as AppCompatActivity
//        activity.setSupportActionBar(toolbar)
//        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
//        // endregion
//    } catch (e: Exception) {
//
//    }
//
//}
//
//fun Any.CameraPermissionChecking(activity: AppCompatActivity, requestCode : Int, onDissmiss : ()->Unit = {}):Boolean{
//
//    val permissionCheck = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
//    if (permissionCheck == PackageManager.PERMISSION_DENIED) {
//        PermissionsDialog(activity).apply {
//            picture = R.drawable.pic_permission_1
//            onclicker = {
//                Log("No Camera Permission, Requesting")
//                //request permission
//                ActivityCompat.requestPermissions(
//                    activity,
//                    arrayOf(Manifest.permission.CAMERA), requestCode
//                )
//                dismiss()
//            }
//            ondismiss = onDissmiss
//            titletext = "카메라 접근 권한이\n" +
//                    "필요합니다."
//            subtetletext = "스쿠터 대여 등록을 위한\n" +
//                    "QR 코드 스캔에 사용됩니다."
//        }.show()
//        return false
//    } else {
//        return true
//
//    }
//
//}
//fun Any.LocationPermissionChecking(activity: AppCompatActivity, requestCode : Int,onDissmiss : ()->Unit = {}) : Boolean {
//
//    val permissionCheck = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
//    if (permissionCheck == PackageManager.PERMISSION_DENIED) {
//        PermissionsDialog(activity).apply {
//            picture = R.drawable.pic_permission_2
//            onclicker = {
//                //request permission
//                ActivityCompat.requestPermissions(
//                    activity,
//                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), requestCode
//                )
//                dismiss()
//            }
//            ondismiss = onDissmiss
//            titletext = "위치 정보 접근 권한이\n" +
//                    "필요합니다."
//            subtetletext = "안전한 라이딩을 위해 라이더의 위치를\n" +
//                    "파악하는데 사용됩니다."
//        }.show()
//        return false
//    } else {
//        return true
//    }
//
//}
//
//fun Any.CustomAlert(Title:String = "", Subtitle:String ="", onClickOKButton : () -> Unit ,onCancelButton : ()->Unit ,onDissmiss: () -> Unit){
//    CustomDialog(context = RydeApplication.context).apply {
//        title = Title
//        subtitle = Subtitle
//        onCancelButtonClick = onCancelButton
//        onOKButtonClick = onClickOKButton
//        this.ondismiss = onDissmiss
//    }.show()
//
//}

fun Fragment.GotoActivity(cls: Class<*>) {
    var intent = Intent(activity, cls)
    this.startActivity(intent)
}

fun Any.getTAG (): String {
    return this.javaClass.simpleName
}

fun Any.Log(str: String){
    android.util.Log.i(this.getTAG(), str)
}
fun Double.roundTo2DecimalPlaces() = BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()

fun View.createBitmapFromView(context: Context): Bitmap {
    val displayMetrics = DisplayMetrics()
    (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
    this.layoutParams =
            WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

    this.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
    this.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
    this.buildDrawingCache()
    val bitmap = Bitmap.createBitmap(this.measuredWidth, this.measuredHeight, Bitmap.Config.ARGB_8888)

    val canvas = Canvas(bitmap)
    this.draw(canvas)

    return bitmap
}

fun String.toLocation() : Location{
    var location = Location("")
    var parsedString = this.split(",")
    location.latitude = parsedString[0].toDouble()
    location.longitude = parsedString[1].toDouble()

    return location
}
//fun String.toGeoPoint() : GeoPoint{
//    var parsedString = this.split(",")
//    var geo = GeoPoint(parsedString[0].toDouble(),parsedString[1].toDouble())
//
//
//    return geo
//}
//fun Location.toFormedString() : String{
//    var rtn = ""
//    rtn = "${latitude},${longitude}"
//    return rtn
//
//}
//fun GeoPoint.toLocation() : Location{
//    var location = Location("")
//    location.latitude = this.latitude
//    location.longitude = this.longitude
//    return location
//}



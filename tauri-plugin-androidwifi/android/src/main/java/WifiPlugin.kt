package com.plugin.androidwifi

import android.app.Activity
import app.tauri.annotation.Command
import app.tauri.annotation.InvokeArg
import app.tauri.annotation.TauriPlugin
import app.tauri.plugin.JSObject
import app.tauri.plugin.Plugin
import app.tauri.plugin.Invoke

import android.Manifest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import android.webkit.WebView
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

@InvokeArg
class Empty {
  var value: String? = null
}

@TauriPlugin
class WifiPlugin(private val activity: Activity): Plugin(activity) {
    private val implementation = WifiDetails()

    @Command
    fun getWifiDetails(invoke: Invoke) {
        val ret = JSObject()
        val json = Json.encodeToString(implementation.getWifiDetails(activity.applicationContext))
        ret.put("wifis", json)
        invoke.resolve(ret)
    }

    private val REQUEST_CODE_WIFI_PERMISSIONS = 1001

    private val requiredPermissions = arrayOf(
        Manifest.permission.ACCESS_WIFI_STATE,
        Manifest.permission.CHANGE_WIFI_STATE,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    override fun load(webView: WebView) {
      super.load(webView)
      // Find any permissions not yet granted.
      val notGrantedPermissions = requiredPermissions.filter {
          ContextCompat.checkSelfPermission(activity.applicationContext, it) != PackageManager.PERMISSION_GRANTED
      }

      // If there are any missing permissions, request them at runtime.
      if (notGrantedPermissions.isNotEmpty()) {
          ActivityCompat.requestPermissions(
              activity,
              notGrantedPermissions.toTypedArray(),
              REQUEST_CODE_WIFI_PERMISSIONS
          )
      } else {
          // Permissions already granted. You can safely use the Wi-Fi APIs.
      }
    }
}

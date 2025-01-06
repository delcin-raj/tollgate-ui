package com.plugin.androidwifi

import android.util.Log

import android.net.wifi.WifiManager 
import android.content.Context
import android.net.wifi.WifiInfo

class Example {
    fun pong(value: String, context: Context): String {
        val manager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager;
        val info = manager.getConnectionInfo();
        return info.getMacAddress();
    }
}

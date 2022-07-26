package com.brandage.apptest.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Patterns
import java.math.BigInteger
import java.security.MessageDigest
import java.text.DecimalFormat

class SharedFile(context: Context) {

    var token = ""
    var name = ""
    var role = ""
    var balance = 0.00F
    var dailyAmount = 0.00F
    var allAmount = 0.00F
    var device = ""
    val PREFS_NAME = "SharedPrefs"
    var emailAdd = ""
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)!!

    fun md5(plainText: String): String {
        val md = MessageDigest.getInstance("MD5")
        val bytes = plainText.toByteArray()
        md.update(bytes, 0, bytes.size)
        return BigInteger(1, md.digest()).toString(16)
    }

     fun formatNumberCurrency(number: String): String {
        val formatter = DecimalFormat("###,###,###.##")
        return formatter.format(number.toDouble())
    }
    fun formatNumber(number: String): String {
        val formatter = DecimalFormat("###,###,###")
        return formatter.format(number.toDouble())
    }

    fun emailValidate(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun save(KEY_NAME: String, text: String?) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(KEY_NAME, text!!.removeSurrounding("\""))
        editor.apply()
    }

    fun save(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(KEY_NAME, value)
        editor.apply()
    }

    fun save(KEY_NAME: String, value: Float) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putFloat(KEY_NAME, value)
        editor.apply()
    }

    fun save(KEY_NAME: String, value: Double) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putFloat(KEY_NAME, value.toFloat())
        editor.apply()
    }

    fun save(KEY_NAME: String, status: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(KEY_NAME, status)
        editor.apply()
    }

    fun getValueString(KEY_NAME: String): String? {
        return sharedPreferences.getString(KEY_NAME.removeSurrounding("\""), null)
    }

    fun getValueInt(KEY_NAME: String): Int {
        return sharedPreferences.getInt(KEY_NAME, 0)
    }

    fun getValueFloat(KEY_NAME: String): Float {
        return sharedPreferences.getFloat(KEY_NAME, 0.00F)
    }

    fun getValueBoolean(KEY_NAME: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(KEY_NAME, defaultValue)

    }

    fun clearSharedAll() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun removeValue(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }
}
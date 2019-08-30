package cl.datageneral.fingerprinttest.data.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Pablo Molina on 10-12-2018. s.pablo.molina@gmail.com
 */
class PreferencesManager (context: Context) {
	val PREFS_NAME = "cl.datageneral.test"
	val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)


	fun get(item:String): String? {
		val temp = ""
		return prefs.getString(item,temp)
	}
	fun getBoolean(item:String): Boolean {
		val temp = false
		return prefs.getBoolean(item,temp)
	}

	fun set(item:String, value:String){
		prefs.edit().putString(item,value).apply()
	}

	fun set(item:String, value:Boolean){
		prefs.edit().putBoolean(item,value).apply()
	}
}
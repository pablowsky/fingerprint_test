package cl.datageneral.fingerprinttest.ui.login

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import cl.datageneral.fingerprinttest.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.act_login.*

class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {

	override fun onCreate(savedInstanceState: Bundle?) {
		//setTheme(R.style.AppTheme_NoActionBar) Solo utilizar si se usa LaunchTheme
		super.onCreate(savedInstanceState)
		setContentView(R.layout.act_login)

		loadingIcon(View.INVISIBLE)

		btn_login.setOnClickListener {
			Log.e("LOGIN","1")
			Log.e("LOGIN,", ":"+System.currentTimeMillis()/1000)


			/*if (checkPermission()) {
				//btnLogIn()
			}*/
		}
	}

	private fun loadingIcon(view: Int) {
		try {
			val pg = pb1
			if (pg != null) {
				pg.visibility = view
			} else
				Log.d("-lI", "NULL")
		} catch (e: Throwable) {
			e.printStackTrace()
		}

	}

	/*private fun btnLogIn() {
		val usuario = username.text.toString()
		val clave 	= password.text.toString()

		if (usuario.isNotEmpty() && clave.isNotEmpty()) {
			enableButton(false)
			loadingIcon(View.VISIBLE)

			/*BVApplication.prefs!!.set(Constants.DEN_USUARIO, usuario)
			BVApplication.prefs!!.set(Constants.DEN_CLAVE, clave)*/

            val intent = Intent("respuestas")
            intent.putExtra("doJob", WebService.SincJobs.LOGIN.value)
			WebService.enqueueWork(this, intent)
		} else {
			Toast.makeText(applicationContext, R.string.msg_userpass, Toast.LENGTH_SHORT).show()
		}
	}



	private fun enableButton(b: Boolean) {
		val bt = btn_login
		bt.isEnabled = b
		if (b)
			bt.background = resources.getDrawable(R.drawable.button_red)
		else
			bt.background = resources.getDrawable(R.drawable.button_red_dis)
		//pg.setVisibility(view);
	}

	private val mMessageReceiver = object : BroadcastReceiver() {
		override fun onReceive(context: Context, intent: Intent) {

			val tMessage 	= intent.getStringExtra("message")
			val status 		= intent.getBooleanExtra("status", false)

			if (status) {
				val nextScreen = Intent(applicationContext, HomeActivity::class.java)
				startActivity(nextScreen)
				finish()
			}else {
				Toast.makeText(applicationContext, tMessage, Toast.LENGTH_LONG).show()
			}
			enableButton(true)
			loadingIcon(View.INVISIBLE)
		}
	}

	public override fun onResume() {
		super.onResume()
		registerReceiver(mMessageReceiver, IntentFilter(WebService.S_BROADCAST))
	}

	override fun onPause() {
		super.onPause()
		unregisterReceiver(mMessageReceiver)
	}

	fun checkPermission(): Boolean {
		val p = Permission(this)
		p.add(Manifest.permission.CAMERA)
		p.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
		if(!p.check()) {
			p.grant()
			return false
		}
		return true
	}*/
}

package cl.datageneral.fingerprinttest.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import cl.datageneral.fingerprinttest.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.act_login.*
import android.content.Intent
import android.widget.TextView
import androidx.core.content.ContextCompat
import cl.datageneral.fingerprinttest.ui.biometric.*
import cl.datageneral.fingerprinttest.ui.inside.InsideActivity
import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {

	@Inject
	lateinit var presenter: LoginPresenter<LoginContract.View>

	@Inject
	lateinit var bm: BiometricsManagerImpl

	override fun onCreate(savedInstanceState: Bundle?) {
		//setTheme(R.style.AppTheme_NoActionBar) Solo utilizar si se usa LaunchTheme
		super.onCreate(savedInstanceState)
		setContentView(R.layout.act_login)

		btn_login.setOnClickListener {
			val user 		= username.text.toString()
			val password 	= password.text.toString()
			presenter.validateCredentials(user, password)
		}

		use_fingerprint.setOnCheckedChangeListener{ _, i ->
			presenter.useFingerprintOption = i
			if(i){
				handleBiometrics()
			}
		}
        presenter.onAttach(this)
		presenter.start()
	}

	override fun getUsername(): String {
		return username.text.toString()
	}

	override fun getPassword(): String {
		return password.text.toString()
	}

	override fun showSnackBarClose(message: String) {
		Log.e("showSnackBarClose", message)
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_INDEFINITE
        )
        val sbView = snackbar.view
        val textView = sbView
            .findViewById<View>(R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.setAction("Cerrar") { }
        snackbar.show()
    }

	override fun credentialValidation(status: CredentialValidation) {
		val msg = when(status){
			CredentialValidation.VALID 				-> "Conectado correctamente"
			CredentialValidation.NO_VALID			-> "Credenciales invalidas"
			CredentialValidation.VALIDATION_ERROR 	-> "Error de comunicacion"
			CredentialValidation.FINGERPRINT_ERROR  -> "Error con huella digital"
		}
		showSnackBarClose(msg)
	}

	override fun loading(value:Int) {
        lyt_loading.visibility = value
	}

	override fun openMainActivity(){
		val nextScreen = Intent(applicationContext, InsideActivity::class.java)
		startActivity(nextScreen)
	}


    override fun handleBiometrics() {
		val subscribe = bm.authenticate(this)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe({ presenter.biometricSuceeded() }, { exception -> presenter.biometricFailure(exception) })
		presenter.addDisposable(subscribe)
    }

	override fun biometricSwitchStatus(status:Boolean) {
		use_fingerprint.isChecked = status
	}

	override fun biometricSwitchView(status: Int) {
		use_fingerprint.visibility = status
	}
}

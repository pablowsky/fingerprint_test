package cl.datageneral.fingerprinttest.ui.login

import cl.datageneral.fingerprinttest.ui.base.BaseContract

/**
 * Created by Pablo Molina on 11-07-2019. s.pablo.molina@gmail.com
 */
class LoginContract {

	interface View: BaseContract.View{
		fun openMainActivity()
		fun handleBiometrics()
		fun biometricSwitchStatus(status:Boolean)
		fun biometricSwitchView(status:Int)
		fun loading(value:Int)
		fun showSnackBarClose(message: String)
		fun credentialValidation(status:CredentialValidation)
		fun getUsername():String
		fun getPassword():String
	}

	interface Presenter{
		fun biometricSuceeded()
		fun biometricFailure(exception: Throwable)
		fun checkBiometric()
		fun validateCredentials(user:String, pass:String)
		fun loginStatus():SessionStatus
		fun credentialsExist():Boolean
		fun start()
	}
}

enum class SessionStatus { FIRST_USE, LOGGED_IN, LOGGED_OUT, SESSION_ENDED }
enum class CredentialValidation { VALID, NO_VALID, VALIDATION_ERROR, FINGERPRINT_ERROR}
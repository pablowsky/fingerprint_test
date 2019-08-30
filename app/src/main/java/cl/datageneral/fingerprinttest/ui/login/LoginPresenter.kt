package cl.datageneral.fingerprinttest.ui.login

import android.view.View
import cl.datageneral.fingerprinttest.data.DataManager
import cl.datageneral.fingerprinttest.ui.base.BasePresenter
import cl.datageneral.fingerprinttest.ui.biometric.BiometricUtils
import cl.datageneral.fingerprinttest.utils.rx.SchedulerProvider
import javax.inject.Inject

/**
 * Created by Pablo Molina on 18-02-2019. s.pablo.molina@gmail.com
 */
class LoginPresenter<V:LoginContract.View>
    @Inject constructor(val dm: DataManager, var bioUtils: BiometricUtils, val sp: SchedulerProvider):
        BasePresenter<V>(),
        LoginContract.Presenter{

    var useFingerprintOption:Boolean = false
        set(value){
            dm.setFingerprintUsage(value)
            field = value
        }

    override fun checkBiometric() {

    }

    override fun start() {
        val sessionStatus = dm.getSessionStatus()
        val userBiometric = dm.getBiometricUsageOption()
        if(statusBiometric()){
            mView?.biometricSwitchView(View.VISIBLE)
        }else{
            mView?.biometricSwitchView(View.GONE)
        }

        when(sessionStatus){
            SessionStatus.LOGGED_IN -> mView?.openMainActivity()
            SessionStatus.LOGGED_OUT,
            SessionStatus.SESSION_ENDED -> {
                if(statusBiometric() && userBiometric){
                    mView?.handleBiometrics()
                }
            }
            SessionStatus.FIRST_USE -> {
                // Se puede enviar algun mensaje de presentacion
            }
        }
    }

    override fun validateCredentials(user:String, pass:String) {
        mView?.loading(View.VISIBLE)
        mCompositeDisposable?.add(dm.validateCredentiales(user, pass)
            .observeOn(sp.ui())
            .subscribeOn(sp.io())
            .subscribe( this::handleInsertSecResponse, this::handleInsertError )
        )
    }

    private fun handleInsertSecResponse( response : Boolean){
        // Falta guardar credenciales
        mView?.loading(View.GONE)
        if(response){
            mView?.credentialValidation(CredentialValidation.VALID)
            // Deberia set un JWT
            dm.setSessionStatus(SessionStatus.LOGGED_IN)
            dm.setUser(mView!!.getUsername())
            dm.setPassword(mView!!.getPassword())
        }else{
            mView?.credentialValidation(CredentialValidation.NO_VALID)
        }
    }

    private fun handleInsertError(error: Throwable){
        mView?.credentialValidation(CredentialValidation.VALIDATION_ERROR)
        mView?.loading(View.GONE)
    }

    override fun biometricSuceeded() {
        if(dm.getSessionStatus()==SessionStatus.LOGGED_IN){
            validateCredentials(dm.getUser(), dm.getPassword())
            mView?.credentialValidation(CredentialValidation.VALID)
        }
    }

    override fun biometricFailure(exception: Throwable) {
        mView?.biometricSwitchStatus(false)
        mView?.credentialValidation(CredentialValidation.FINGERPRINT_ERROR)
    }

    private fun statusBiometric():Boolean {
        return (bioUtils.isBiometricPromptEnabled 	&&
                bioUtils.isSdkVersionSupported 		&&
                bioUtils.isFingerprintAvailable()   &&
                bioUtils.isHardwareSupported() 	    &&
                bioUtils.isPermissionGranted())
    }

    override fun credentialsExist(): Boolean {
        return true
    }

    override fun loginStatus():SessionStatus {
        return dm.getSessionStatus()
    }
}
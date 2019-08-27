package cl.datageneral.fingerprinttest.ui.login

import cl.datageneral.fingerprinttest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Pablo Molina on 18-02-2019. s.pablo.molina@gmail.com
 */
class LoginPresenter<V:LoginContract.View>@Inject constructor():
        BasePresenter<V>(),
        LoginContract.Presenter{

    fun guardarInspeccion(){
    }

}
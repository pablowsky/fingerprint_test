package cl.datageneral.fingerprinttest.ui.login

import cl.datageneral.fingerprinttest.data.DataManager
import cl.datageneral.fingerprinttest.ui.biometric.BiometricUtils
import cl.datageneral.fingerprinttest.utils.rx.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Pablo Molina on 11-07-2019. s.pablo.molina@gmail.com
 */
@Module
abstract class LoginModule{

	@Binds
	abstract fun provideLoginActivityView(subMenuActivity: LoginActivity): LoginContract.View

	@Module
	companion object {

		@JvmStatic
		@Provides
		fun provideLoginPresenter(dm: DataManager, bioUtils: BiometricUtils, sp: SchedulerProvider): LoginPresenter<LoginContract.View> = LoginPresenter(dm, bioUtils, sp)
	}
}
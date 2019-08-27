package cl.datageneral.fingerprinttest.ui.login

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
		//fun provideAuditEditionePresenter(dm: DataManager, sp: SchedulerProvider): AuditEditionPresenter<AuditEditionContract.View> = AuditEditionPresenter(dm, sp)
		fun provideAuditEditionePresenter(): LoginPresenter<LoginContract.View> = LoginPresenter()
	}
}
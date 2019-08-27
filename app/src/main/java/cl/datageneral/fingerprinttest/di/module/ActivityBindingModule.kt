package cl.datageneral.fingerprinttest.di.module

import cl.datageneral.fingerprinttest.ui.login.LoginActivity
import cl.datageneral.fingerprinttest.ui.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

   /*@ContributesAndroidInjector(modules = [MainActivityModule::class])
    @MainActivityScope
    abstract fun bindMainActivity(): MainActivity*/

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    /*@ContributesAndroidInjector(modules = [AuditEditionModule::class])
    abstract fun bindAuditEditionActivity(): AuditEditionActivity*/


}
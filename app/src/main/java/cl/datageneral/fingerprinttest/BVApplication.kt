package cl.datageneral.fingerprinttest

import cl.datageneral.fingerprinttest.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Pablo Molina on 18-07-2018. s.pablo.molina@gmail.com
 */
class BVApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }
}
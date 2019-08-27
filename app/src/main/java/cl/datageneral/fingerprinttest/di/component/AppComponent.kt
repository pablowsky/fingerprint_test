package cl.datageneral.fingerprinttest.di.component

import cl.datageneral.fingerprinttest.BVApplication
import cl.datageneral.fingerprinttest.di.module.ActivityBindingModule
import cl.datageneral.fingerprinttest.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Pablo Molina on 29-03-2019. s.pablo.molina@gmail.com
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: BVApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BVApplication): Builder
        fun build(): AppComponent
    }
}
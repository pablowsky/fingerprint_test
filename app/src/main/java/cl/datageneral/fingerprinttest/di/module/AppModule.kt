package cl.datageneral.fingerprinttest.di.module

import android.content.Context
import cl.datageneral.fingerprinttest.BVApplication
import cl.datageneral.fingerprinttest.data.DataManager
import cl.datageneral.fingerprinttest.data.prefs.PreferencesManager
import cl.datageneral.fingerprinttest.ui.biometric.BiometricUtils
import cl.datageneral.fingerprinttest.ui.biometric.BiometricsManagerImpl
import cl.datageneral.fingerprinttest.utils.rx.SchedulerProvider
import cl.datageneral.fingerprinttest.utils.rx.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Pablo Molina on 29-03-2019. s.pablo.molina@gmail.com
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: BVApplication) : Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideSchedulerProvider(): SchedulerProvider = SchedulerProviderImpl()

        @JvmStatic
        @Provides
        fun provideDataManager(p: PreferencesManager): DataManager = DataManager(p)

        @JvmStatic
        @Provides
        fun providePreferencesManager(context: Context): PreferencesManager = PreferencesManager(context)

        @JvmStatic
        @Provides
        fun provideBiometricUtils(context: Context): BiometricUtils = BiometricUtils(context)

        @JvmStatic
        @Provides
        fun provideBiometricsManager(): BiometricsManagerImpl = BiometricsManagerImpl()
    }
}
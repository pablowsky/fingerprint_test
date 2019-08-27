package cl.datageneral.fingerprinttest.di.module

import android.content.Context
import cl.datageneral.fingerprinttest.BVApplication
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
/*
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideDataManager(q: Query, p: MyPrefs, a: ApiInterface): DataManager = DataManager(q, p, a)

        @JvmStatic
        @Provides
        fun provideSchedulerProvider(): SchedulerProvider = SchedulerProviderImpl()

        @JvmStatic
        @Provides
        fun provideMyPrefs(context: Context): MyPrefs = MyPrefs(context)

        @JvmStatic
        @Provides
        fun provideQuery(): Query = Query()
    }*/
}
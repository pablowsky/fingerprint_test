package cl.datageneral.fingerprinttest

import cl.datageneral.fingerprinttest.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Pablo Molina on 18-07-2018. s.pablo.molina@gmail.com
 */
class BVApplication : DaggerApplication() {
    /*companion object {
    	var prefs: MyPrefs?=null
    }*/

    override fun onCreate() {
        //prefs = MyPrefs(applicationContext)
        super.onCreate()
        //Realm.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }
    /*
    private fun scheduleJob() {

        if (!prefs!!.getBoolean("SCHEDULED")) {
			Log.e("BVApplication","Registrando")
            val jobScheduler = applicationContext
                    .getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

            val componentName = ComponentName(this, ScheduledJob::class.java)

            val jobInfo = JobInfo.Builder(1, componentName)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setPersisted(true)
                    .build()
            val resultCode = jobScheduler.schedule(jobInfo)
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Log.d("BVApplication", "Job scheduled!")
            } else {
                Log.d("BVApplication", "Job not scheduled")
            }

            prefs!!.set("SCHEDULED",true)
        }
    }*/
}
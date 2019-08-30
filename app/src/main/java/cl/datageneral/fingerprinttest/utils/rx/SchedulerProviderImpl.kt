package cl.datageneral.fingerprinttest.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Pablo Molina on 09-04-2019. s.pablo.molina@gmail.com
 */
class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

	override fun ui(): Scheduler {
		return AndroidSchedulers.mainThread()
	}

	override fun computation(): Scheduler {
		return Schedulers.computation()
	}

	override fun io(): Scheduler {
		return Schedulers.io()
	}

}
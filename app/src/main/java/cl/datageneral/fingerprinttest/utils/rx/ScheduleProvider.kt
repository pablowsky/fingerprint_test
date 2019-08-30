package cl.bureauveritas.auditorias.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Pablo Molina on 09-04-2019. s.pablo.molina@gmail.com
 */
interface SchedulerProvider {

	fun ui(): Scheduler

	fun computation(): Scheduler

	fun io(): Scheduler

}
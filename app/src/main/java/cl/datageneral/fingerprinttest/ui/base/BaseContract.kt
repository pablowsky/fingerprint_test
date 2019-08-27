package cl.datageneral.fingerprinttest.ui.base

/**
 * Created by Pablo Molina on 04-02-2019. s.pablo.molina@gmail.com
 */
class BaseContract {

    interface Presenter<V: View> {
        fun subscribe()
        fun unsubscribe()
        fun onAttach(view: V)
        fun onDetach()
    }

    interface View
}
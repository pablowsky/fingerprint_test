package cl.bureauveritas.auditorias.data.network

import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver

/**
 * Created by Pablo Molina on 10-01-2019. s.pablo.molina@gmail.com
 */
/*
open class ServiceResultReceiver : ResultReceiver(Handler()) {

	private lateinit var receiverCallback: ServiceReceiver

	companion object {
		val RESULT_CODE_OK = 1100
		val RESULT_CODE_ERROR = 555
		val PARAM_RESULT = "result"
		val PARAM_EXCEPTION = "exception"
	}


	fun setReceiver(resultReceiverCallback: ServiceReceiver) {
		receiverCallback = resultReceiverCallback
	}

	override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
		super.onReceiveResult(resultCode, resultData)

		//if (receiverCallback !=null ) {
			receiverCallback.onReceiveResult(resultCode, resultData)
			//receiverCallback.onSuccess(resultData!!.getSerializable(PARAM_RESULT))
		/*} else {
			receiverCallback.onError(resultData!!.getSerializable(PARAM_EXCEPTION) as Exception)
		}*/
	}

	interface ServiceReceiver {
		fun onReceiveResult(resultCode: Int, resultData: Bundle?)
	}
}*/


class ServiceResultReceiver(_callback : ResultCallback) : ResultReceiver( Handler() )
{
	private val callback = _callback

	override fun onReceiveResult(resultCode: Int, bundle: Bundle)
	{
		super.onReceiveResult(resultCode, bundle)

		callback.queryResult( bundle )
		/*
		when( resultCode )
		{
			CountdownService.SERVICE_RESULT_CODE_ALREADY_RUNNING -> { callback.alreadyRunning( bundle )}
			CountdownService.SERVICE_RESULT_CODE_QUERY -> { callback.queryResult( bundle ) }
			else -> { throw IllegalStateException("Result Code is not ALREADY_RUNNING or QUERY") }
		}*/
	}

	interface ResultCallback {
		fun alreadyRunning( bundle : Bundle )
		fun queryResult( bundle : Bundle)
	}

}
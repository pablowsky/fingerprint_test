package cl.datageneral.fingerprinttest.utils

import android.os.Environment

/**
 * Created by Pablo Molina on 23-10-2018. s.pablo.molina@gmail.com
 */
open class Constants {
	companion object {
		val STAT_P = "P" // Estado pendiente
		val STAT_E = "E" // Estado en proceso
		val STAT_T = "T" // Estado terminado
		val STAT_C = "C" // Estado Cancelada
		val STAT_NC = "NC" // Estado con no conformidades

		val SHARED_PREFERENCES = "prefInspNuevo"
		val TAG_XML = "registro"
		val INPUT_PATH = "/TempZip"
		val ID_USUARIO 	= "idUsuario"

		const val PICK_IMAGE_ID = 101

		val C_RESULT_OK = -1
		val C_RESULT_CANCELED = 0

		val URI_IMGS = Environment.
				getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()+ "/BV_IMAGENES/"

		const  val connTimeOut:Long  = 15
		const  val readTimeOut:Long  = 180
		const  val writeTimeOut:Long = 300
	}
}
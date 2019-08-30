package cl.datageneral.fingerprinttest.data.network

import retrofit2.http.*
import io.reactivex.Observable

/**
 * Created by Pablo Molina on 13-12-2018. s.pablo.molina@gmail.com
 */
interface ApiInterface{
/*
	@FormUrlEncoded
	@POST("auditoria")
	fun sendRespuesta(@Field("evaluacion") 	evaluacion: String?,
					@Field("evidencia") 	evidencia: String?,
					@Field("hallazgo") 		hallazgo: String?,
					@Field("idUsuario") 	idUsuario: Int,
					@Field("idRespuesta") 	idRespuesta: Int): Observable<AudInsert>

	@GET("secuencia/{classname}/")
	fun getSecuencia(@Path("classname") classname: String): Observable<SecuenciasResponse>

	@GET("auditoria/{idusuario}/")
	fun getAudits(@Path("idusuario") idusuario: String): Observable<AuditsResponse>*/

/*
	@Multipart
	@POST("service/inspecciones/")
	fun upload(@Query("description") description: String,
			   @Part file: MultipartBody.Part): Call<UploadResponse>

	@GET("service/secuencias/{classname}/")
	fun getSecuencia(@Path("classname") classname: String): Call<SecuenciasResponse>

	@GET("service/motivos/")
	fun getMotivos(): Call<MotivosResponse>

	@GET("service/itemslistas/")
	fun getItemsListas(): Call<ItemListaResponse>

	@GET("service/equipos/")
	fun getEquipos(): Call<EquiposResponse>

	@GET("service/tipoanclaje/")
	fun getTiposAnclajes(): Call<TiposAnclajesResponse>*/

	companion object Factory {
		val BASE_URL = "http://10.29.18.143/auditorias/"
		/*//val BASE_URL = "http://portalservicios.bureauveritas.cl/app/sipa/api/"
		fun create(context: Context): ApiInterface {
			val logging = HttpLoggingInterceptor()
// set your desired log level
			logging.level = HttpLoggingInterceptor.Level.BODY

			//var client = OkHttpClient()
			val builder = OkHttpClient.Builder()
			builder.addInterceptor(AddCookiesInterceptor(context))
			builder.addInterceptor(ReceivedCookiesInterceptor(context))
			builder.addInterceptor(logging) // Para ver respuesta de servidor
			builder.connectTimeout(Constants.connTimeOut, TimeUnit.SECONDS)
			builder.readTimeout(Constants.readTimeOut, TimeUnit.SECONDS)
			builder.writeTimeout(Constants.writeTimeOut, TimeUnit.SECONDS)
			val client = builder.build()

			val retrofit = Retrofit.Builder()
					.baseUrl(BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.client(client)
					.build()
			return retrofit.create(ApiInterface::class.java)
		}*/


	}


}
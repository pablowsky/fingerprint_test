package cl.datageneral.fingerprinttest.data.network.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Pablo Molina on 27-02-2019. s.pablo.molina@gmail.com
 */

class LoginResponse {

    @SerializedName("msg")
    var msg: String     = ""

    @SerializedName("name")
    var name: String    = ""

    @SerializedName("idUser")
    var idUser: Int     = 0

    @SerializedName("error_cod")
    var errorCod: Int   = 0
}
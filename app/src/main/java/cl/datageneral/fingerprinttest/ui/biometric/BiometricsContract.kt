package cl.datageneral.fingerprinttest.ui.biometric

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable

interface BiometricsManager {
    fun authenticate(activity: AppCompatActivity): Completable
}

class BiometricCancelledException(message: String? = null) : Exception(message)

class BiometricsNotAvailableException(message: String? = null) : Exception(message)
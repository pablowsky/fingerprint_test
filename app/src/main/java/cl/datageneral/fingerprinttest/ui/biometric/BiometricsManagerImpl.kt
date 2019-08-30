package cl.datageneral.fingerprinttest.ui.biometric

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricConstants
import androidx.biometric.BiometricPrompt
import io.reactivex.Completable
import java.util.concurrent.Executor

/**
 * Created by Pablo Molina on 28-08-2019. s.pablo.molina@gmail.com
 */
class BiometricsManagerImpl : BiometricsManager {

    private val executor = MainThreadExecutor()

    override fun authenticate(activity: AppCompatActivity): Completable {
        return Completable.create { emitter ->
            val prompt = BiometricPrompt(
                activity,
                executor,
                object : BiometricPrompt.AuthenticationCallback() {
                    @SuppressLint("SwitchIntDef")
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        val exception = when (errorCode) {
                            BiometricConstants.ERROR_HW_NOT_PRESENT,
                            BiometricConstants.ERROR_HW_UNAVAILABLE,
                            BiometricConstants.ERROR_NO_BIOMETRICS ->
                                BiometricsNotAvailableException("Code: $errorCode, Message: $errString")
                            else -> BiometricCancelledException("Code: $errorCode, Message: $errString")
                        }

                        emitter.onError(exception)
                    }

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        emitter.onComplete()
                    }
                })

            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setDescription("descripcion de prueba")
                .setNegativeButtonText("Cancelar")
                .build()

            prompt.authenticate(promptInfo)
        }
    }

    inner class MainThreadExecutor : Executor {
        private val handler = Handler(Looper.getMainLooper())

        override fun execute(runnable: Runnable) {
            handler.post(runnable)
        }
    }
}
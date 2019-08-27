package cl.datageneral.fingerprinttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.datageneral.fingerprinttest.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextScreen = Intent(applicationContext, LoginActivity::class.java)
        startActivity(nextScreen)
        finish()
    }
}

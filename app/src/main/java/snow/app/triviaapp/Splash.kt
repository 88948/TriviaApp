package snow.app.triviaapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import snow.app.triviaapp.view.NameActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //go to name screen
        openNameScreen()
    }


    fun openNameScreen() {

        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@Splash, NameActivity::class.java))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity()
            } else {
                finish()
            }
        }, 1500)

    }
}
package fr.iim.mydummyapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), HomeFragment.HomeFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, HomeFragment.newInstance())
            .commitNow()

        Log.d(LOG_TAG, "onCreate")
    }

    override fun OnHelloClickListener(firstName: String) {
        Log.d(LOG_TAG, "click event sent $firstName")

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, HelloFragment.newInstance(firstName))
            .commitNow()
    }

    companion object {
        private val LOG_TAG = "MainActivity"
    }
}
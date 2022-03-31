package fr.iim.mydummyapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class MainActivity : AppCompatActivity(), HomeFragment.HomeFragmentListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = "Rendu-Kotlin"



        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, HomeFragment.newInstance())
            .commitNow()


    }

    private fun isValidString(email: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isValidPassword(password: String): Boolean {
        val passwordREGEX = Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$")
        return passwordREGEX.matcher(password).matches()

    }





        override fun onHelloClickListener(email: String, password: String) {


        if (isValidString(email) )
        {
            if (isValidPassword(password))
            {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.mainContainer, HelloFragment.newInstance(email))
                    .commitNow()
            }

            else
                Log.d("MainActivity", "password not valid")

        }

        else
            Log.d("MainActivity", "email not valid")


    }

}
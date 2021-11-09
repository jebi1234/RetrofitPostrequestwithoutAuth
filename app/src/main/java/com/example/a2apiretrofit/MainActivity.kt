package com.example.a2apiretrofit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    var Textview:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Textview = findViewById<TextView>(R.id.textview)

        val Submit = findViewById<Button>(R.id.button)

        Submit.setOnClickListener {

            login()

        }

    }

    private fun login() {

        val request =
            Loginrequestdetails(
                "f6f2d0e2c2fccaeg",
                "Android",
                "1.0",
                "en",
                "1.0",
                "12.23.23",
                "125.25325",
                "125.25328",
                "NA",
                "NA",
                "NA"

            )
        val service = RetrofitClient().webService
        CoroutineScope(Dispatchers.IO).launch {
            try {


                val response = service.logindetails(request)

                withContext(Dispatchers.Main) {
                    when {
                        response!!.isSuccessful -> {
                            // doSome(response.body())

                            doSome2(response.body())

                            println("==loginresponse==${response.body()}")

                        }
                        else -> {

                            Toast.makeText(this@MainActivity,"server error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            } finally {
                Log.e("TAG", "sendRequest: ")
            }
        }
    }


    private fun doSome2(body: ResponseDetalis?) {
        Log.e("TAG Ranjith", "doSome: ${body!!.status}")

            Textview?.setText(
                body.status.toString()+"\n"+body.timeStamp.toString())
    }
}
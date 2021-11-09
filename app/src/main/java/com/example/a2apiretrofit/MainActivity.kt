package com.example.a2apiretrofit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    var Textview:TextView? = null

    var Textvie:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Textview = findViewById<TextView>(R.id.textview)
        Textvie = findViewById<TextView>(R.id.tx)


        val Submit = findViewById<Button>(R.id.button)

        Submit.setOnClickListener {

            login()
            sendOtp()

        }

    }

    private fun sendOtp() {
        val requestsendotp = sendOtprequest(

            "f6f2d0e2c2fcc9eg",
            "en",
            "966513333333",
            "SA",
            "1.0.4",
            "Android",
            "1.0"
        )
        val service = RetrofitClient().webService
        CoroutineScope(Dispatchers.IO).launch {
            try {


                val response = service.sendotpdetails(requestsendotp)

                withContext(Dispatchers.Main) {
                    when {
                        response!!.isSuccessful -> {
                            // doSome(response.body())

//                            Toast.makeText(this@MainActivity,
//                                response.body()?.status.toString()+"\n"+ response.body()?.timeStamp.toString(),Toast.LENGTH_LONG).show()
                            doSome4(response.body())
                            if(response.body()?.status.equals("1013"))
                                Toast.makeText(this@MainActivity,"OTP SEND",Toast.LENGTH_LONG).show()
//
//                            println("==loginresponse==${response.body()}")

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

    private fun doSome4(body: ResponseSendOtpDetails?) {
        Log.v("TAG Ranjith", "doSome: ${body!!.status}")

        Textvie?.setText(
            body.status.toString()+"\n"+body.timeStamp.toString())
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
        Log.v("TAG Ranjith", "doSome: ${body!!.status}, ${body!!.timeStamp}")

        Textview?.setText(
            body.status.toString()+"\n"+body.timeStamp.toString())
    }
}
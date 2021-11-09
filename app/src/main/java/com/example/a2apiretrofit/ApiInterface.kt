package com.example.loginapiretrofit

import com.example.a2apiretrofit.Loginrequestdetails
import com.example.a2apiretrofit.ResponseDetalis
import com.example.a2apiretrofit.ResponseSendOtpDetails
import com.example.a2apiretrofit.sendOtprequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


const val BASE_URL = "https://api.mrmoasilha.com/"
interface ApiInterface {


    @POST(value = "v1/appdownloaddetails")
    suspend fun logindetails(@Body request: Loginrequestdetails): Response<ResponseDetalis>?

    @POST(value = "v1/forget/pwd/mpin/sendotp")
    suspend fun sendotpdetails(@Body request: sendOtprequest): Response<ResponseSendOtpDetails>?


}
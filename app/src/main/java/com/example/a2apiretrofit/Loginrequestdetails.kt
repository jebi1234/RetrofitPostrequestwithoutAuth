package com.example.a2apiretrofit

data class Loginrequestdetails (

    val deviceId:String,
    val deviceType:String,
    val deviceModel:String,
    val deviceVersion:String,
    val appVersion:String,
    val buildId:String,
    val macAddress:String,
    val longitude:String,
    val latitude:String,
    val iPAddress:String,
    val pushNotificationToken:String

)
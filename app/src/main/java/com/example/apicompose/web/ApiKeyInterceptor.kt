package com.example.apicompose.web

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request()
            .newBuilder()
            .header("X-API-KEY", "X9VHF77-A25MBGS-NZCSRQB-BC4S8RF")
            .build()
        return chain.proceed(newRequest)
    }
}
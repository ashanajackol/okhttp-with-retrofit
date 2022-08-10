package com.example.ashana.retrofitwithokhttp

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.logging.Logger

class MyHttpInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var t1 = System.nanoTime()
        println("Interceptor : Sending request on $t1 ${request.url} ${chain.connection()} ${request.headers}")

        val response = chain.proceed(request)

        var t2 = System.nanoTime()
        println("Interceptor : Received response at ${t2-t1} ${response.request} ${response.headers}")

        when (response.code) {
            400 -> {
               println("ERROR! bad request error!")
            }
            401 -> {
                println("ERROR! unauthorised error!")
            }
            403 -> {
                println("ERROR! restricted site!")
            }
            404 -> {
                println("ERROR! page not found!")
            }
        }

        return response
    }
}
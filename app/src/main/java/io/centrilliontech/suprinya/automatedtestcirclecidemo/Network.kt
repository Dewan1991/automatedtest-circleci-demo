package io.centrilliontech.suprinya.automatedtestcirclecidemo

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object Network {
    private const val API_HOST_RETROFIT = "https://ctrlyati.app/dev/ecom/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(API_HOST_RETROFIT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Retrieve response body to Rxjava2 type
                .addConverterFactory(GsonConverterFactory.create()) //Retrieve response Gson data
                .client(okHttpClient)
                .build()
    }

    val shoesService: ShoesService by lazy {
        retrofit.create(ShoesService::class.java)
    }

}
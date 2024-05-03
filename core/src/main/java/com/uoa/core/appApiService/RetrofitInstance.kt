package com.uoa.core.appApiService

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        val BASE_URL="https://"

        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client((OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply { level=HttpLoggingInterceptor.Level.BODY })
                    .build()))
                .build()
        }
    }
}
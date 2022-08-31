package com.example.masterclass.core.networking

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    fun provideApiService(
        okHttpClient: OkHttpClient
    ): ApiService {
        return Retrofit
            .Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}

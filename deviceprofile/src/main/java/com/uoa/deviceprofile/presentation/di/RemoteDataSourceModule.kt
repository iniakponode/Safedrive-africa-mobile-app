package com.uoa.deviceprofile.presentation.di

import com.uoa.deviceprofile.data.datasources.RemoteDataSource
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object RemoteDataSourceModule{


    fun provideRemoteDataSource(remoteDataSource: RemoteDataSource): RemoteDataSource{
        return remoteDataSource
    }
}
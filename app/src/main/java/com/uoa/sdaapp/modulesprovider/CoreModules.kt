package com.uoa.sdaapp.modulesprovider

import android.content.Context
import androidx.room.Room
import com.uoa.sdaapp.appApiService.RetrofitInstance
import com.uoa.sdaapp.db.Sdaapp
import com.uoa.sensordatacollection.data.api.SensorDataApiService
import com.uoa.sensordatacollection.data.dao.SensorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModules {

    @Singleton
    @Provides
    fun provideNetworkService(): RetrofitInstance {
        return RetrofitInstance()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): Sdaapp {
        return Room.databaseBuilder(
            context,
            Sdaapp::class.java,
            "app_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideSensorDataDao(appDatabase: Sdaapp): SensorDao {
        return appDatabase.sensordao()
    }

    @Singleton
    @Provides
    fun provideSensorDataApiService(): SensorDataApiService {
        return RetrofitInstance.getRetrofitInstance().create(SensorDataApiService::class.java)
    }
}

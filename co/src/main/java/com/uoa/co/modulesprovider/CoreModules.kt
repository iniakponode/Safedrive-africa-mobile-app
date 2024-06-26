package com.uoa.co.modulesprovider

import android.content.Context
import androidx.room.Room
import com.uoa.co.appApiService.RetrofitInstance
import com.uoa.co.db.Sdaapp
import com.uoa.co.db.dao.DriverProfileDao
import com.uoa.co.appApiService.SensorDataApiService
import com.uoa.co.db.dao.SensorDao
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

    @Provides
    @Singleton
    fun provideDriverProfileDao(appDatabase: Sdaapp): DriverProfileDao {
        return appDatabase.driverProfile()
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

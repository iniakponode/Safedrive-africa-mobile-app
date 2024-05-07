package com.uoa.co.appApiService

import com.uoa.co.db.entity.SensorDataEntity
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SensorDataApiService {

    // Endpoint to send a single SensorDataEntity to the server
    @POST("sensorData")
    suspend fun sendSensorData(@Body sensorData: SensorDataEntity)

    // Endpoint to send a list of SensorDataEntity objects to the server
    @POST("sensorData/bulk")
    suspend fun sendBulkSensorData(@Body sensorDataList: List<SensorDataEntity>)

    // Endpoint to get sensor data associated with a specific tripDataId from the server
    @GET("sensorData/trip/{tripDataId}")
    suspend fun getSensorDataForTrip(@Path("tripDataId") tripDataId: Long): List<SensorDataEntity>

    // Endpoint to get sensor data by its id from the server
    @GET("sensorData/{sensorDataId}")
    suspend fun getSensorDataById(@Path("sensorDataId") sensorDataId: Long): SensorDataEntity

    // Endpoint to delete a single sensor data by its id on the server
    @DELETE("sensorData/{sensorDataId}")
    suspend fun deleteSensorDataById(@Path("sensorDataId") sensorDataId: Long)

    // Endpoint to delete all sensor data associated with a specific tripDataId on the server
    @DELETE("sensorData/trip/{tripDataId}")
    suspend fun deleteSensorDataForTrip(@Path("tripDataId") tripDataId: Long)

    // Endpoint to delete all sensor data on the server
    @DELETE("sensorData")
    suspend fun deleteAllSensorData()
}
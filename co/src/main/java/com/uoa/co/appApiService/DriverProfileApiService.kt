package com.uoa.co.appApiService

import com.uoa.co.db.entity.DriverProfileDataEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface DriverProfileApiService {
    @POST("profiles")
    suspend fun createProfile(@Body deviceProfile: DriverProfileDataEntity): Response<DriverProfileDataEntity>

    @PUT("profiles/{id}")
    suspend fun updateProfile(@Path("id") id: Int, @Body deviceProfile: DriverProfileDataEntity): Response<DriverProfileDataEntity>

    @GET("profiles/{id}")
    suspend fun getDeviceProfile(@Path("id") id: String): Response<DriverProfileDataEntity>

    @GET("profiles")
    suspend fun getDeviceProfiles(): Response<List<DriverProfileDataEntity>>

    @GET("profile/{email, password}")
    suspend fun login(@Query("email") email: String, @Query("password") password: String): Response<DriverProfileDataEntity>

    // Additional network calls as needed
}

data class ApiResponse(val success: Boolean, val message: String)
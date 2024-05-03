package com.uoa.sensordatacollection.domain.usecase

//import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import com.uoa.sensordatacollection.data.datasources.remote.RemoteSensorRepository
import com.uoa.core.db.entity.SensorDataEntity
import javax.inject.Inject

class SaveSensorDataToRemoteDBUseCase @Inject constructor(
    private val remoteSensorRepository: RemoteSensorRepository
) {
    suspend fun execute(sensorDataEntity: com.uoa.core.db.entity.SensorDataEntity){
            return remoteSensorRepository.sendSensorData(sensorDataEntity)
    }
}
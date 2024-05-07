package com.uoa.sensordatacollection.domain.usecase

import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import com.uoa.co.db.entity.SensorDataEntity
import javax.inject.Inject

class SaveSensorDataToLocalDatabaseUseCase @Inject constructor(
    private val localSensorRepository: LocalSensorRepository
) {
    suspend fun execute(sensorDataEntity: com.uoa.co.db.entity.SensorDataEntity){
        return localSensorRepository.insertSensorData(sensorDataEntity)
    }
}
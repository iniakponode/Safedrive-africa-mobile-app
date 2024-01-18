package com.uoa.sensordatacollection.domain.usecase

import com.uoa.sensordatacollection.data.datasources.local.LocalSensorRepository
import com.uoa.sensordatacollection.data.model.SensorDataEntity
import javax.inject.Inject

class SaveSensorDataToLocalDatabaseUseCase @Inject constructor(
    private val localSensorRepository: LocalSensorRepository
) {
    suspend fun execute(sensorDataEntity: SensorDataEntity){
        return localSensorRepository.insertSensorData(sensorDataEntity)
    }
}
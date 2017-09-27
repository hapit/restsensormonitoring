package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.dtos.CreateVibrationSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.VibrationSensorValueDto
import de.hapit.restsensormonitoring.monitoring.entities.VibrationSensorValueEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
@Transactional
internal class JpaVibrationSensorValueService(val vibrationSensorValueRepository: VibrationSensorValueRepository) : VibrationSensorService {


    override fun retrieveAllVibrationSensorValues(): List<VibrationSensorValueDto> {
        return vibrationSensorValueRepository.findAll().map { it -> it.toDto() }
    }

    override fun addVibrationSensorValue(createVibrationSensorValueDto: CreateVibrationSensorValueDto): VibrationSensorValueDto {
        return vibrationSensorValueRepository.save(VibrationSensorValueEntity.fromDto(createVibrationSensorValueDto)).toDto()
    }

    override fun retrieveVibrationSensorValuesAfter(time: LocalDateTime): List<VibrationSensorValueDto> {
        return vibrationSensorValueRepository.findByDatetimeAfter(time).map { it -> it.toDto() }
    }

    override fun retrieveVibrationSensorValuesBetween(start: LocalDateTime, end: LocalDateTime): List<VibrationSensorValueDto> {
        return vibrationSensorValueRepository.findByDatetimeBetween(start, end).map { it -> it.toDto() }
    }

    override fun countVibrationSensorValues(): Long {
        return vibrationSensorValueRepository.count()
    }


}
package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.dtos.CreateSoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.entities.SoundSensorValueEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
@Transactional
internal class JpaSoundSensorValueService(val soundSensorValueRepository: SoundSensorValueRepository) : SoundSensorService {


    override fun retrieveAllSoundSensorValues(): List<SoundSensorValueDto> {
        return soundSensorValueRepository.findAll().map { it -> it.toDto() }
    }

    override fun addSoundSensorValue(createSoundSensorValueDto: CreateSoundSensorValueDto): SoundSensorValueDto {
        return soundSensorValueRepository.save(SoundSensorValueEntity.fromDto(createSoundSensorValueDto)).toDto()
    }

    override fun retrieveSoundSensorValuesAfter(time: LocalDateTime): List<SoundSensorValueDto> {
        return soundSensorValueRepository.findByDatetimeAfter(time).map { it -> it.toDto() }
    }

    override fun retrieveSoundSensorValuesBetween(start: LocalDateTime, end: LocalDateTime): List<SoundSensorValueDto> {
        return soundSensorValueRepository.findByDatetimeBetween(start, end).map { it -> it.toDto() }
    }

    override fun countSoundSensorValues(): Long {
        return soundSensorValueRepository.count()
    }


}
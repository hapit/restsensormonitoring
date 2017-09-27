package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.dtos.CreateSoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorValueDto
import java.time.LocalDateTime
import java.util.*

interface SoundSensorService {

    fun addSoundSensorValue(createSoundSensorValueDto: CreateSoundSensorValueDto): SoundSensorValueDto

    fun retrieveAllSoundSensorValues(): List<SoundSensorValueDto>

    fun retrieveSoundSensorValuesAfter(time: LocalDateTime): List<SoundSensorValueDto>

    fun retrieveSoundSensorValuesBetween(start: LocalDateTime, end: LocalDateTime): List<SoundSensorValueDto>

    fun countSoundSensorValues(): Long
}
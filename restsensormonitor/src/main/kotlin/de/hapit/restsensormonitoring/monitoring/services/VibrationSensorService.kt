package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.dtos.CreateSoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.CreateVibrationSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.VibrationSensorValueDto
import java.time.LocalDateTime

interface VibrationSensorService {

    fun addVibrationSensorValue(createVibrationSensorValueDto: CreateVibrationSensorValueDto): VibrationSensorValueDto

    fun retrieveAllVibrationSensorValues(): List<VibrationSensorValueDto>

    fun retrieveVibrationSensorValuesAfter(time: LocalDateTime): List<VibrationSensorValueDto>

    fun retrieveVibrationSensorValuesBetween(start: LocalDateTime, end: LocalDateTime): List<VibrationSensorValueDto>

    fun countVibrationSensorValues(): Long
}
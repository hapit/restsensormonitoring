package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.entities.SoundSensorValueEntity
import de.hapit.restsensormonitoring.monitoring.entities.VibrationSensorValueEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
internal interface VibrationSensorValueRepository : JpaRepository<VibrationSensorValueEntity, Long> {
    fun findByDatetimeBetween(start: LocalDateTime, end: LocalDateTime) : List<VibrationSensorValueEntity>
    fun findByDatetimeAfter(time: LocalDateTime) : List<VibrationSensorValueEntity>
}
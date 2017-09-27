package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.entities.SoundSensorValueEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
internal interface SoundSensorValueRepository : JpaRepository<SoundSensorValueEntity, Long> {
    fun findByDatetimeBetween(start: LocalDateTime, end: LocalDateTime) : List<SoundSensorValueEntity>
    fun findByDatetimeAfter(time: LocalDateTime) : List<SoundSensorValueEntity>
}
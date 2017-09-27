package de.hapit.restsensormonitoring.monitoring.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class CreateVibrationSensorValueDto(@NotNull val vibrationsensor: Int)
data class VibrationSensorValueDto(
        @JsonIgnore
        val id: Long,
        val datetime: LocalDateTime,
        val value: Int)
package de.hapit.restsensormonitoring.monitoring.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.validation.constraints.NotNull


data class SoundSensorDto(@NotNull val soundsensor: CreateSoundSensorValueDto)

data class CreateSoundSensorValueDto(@NotNull val avg: Int, @NotNull val max: Int)

data class SoundSensorValueDto(
        @JsonIgnore
        val id: Long,
        val datetime: LocalDateTime,
        val avg: Int,
        val max: Int)

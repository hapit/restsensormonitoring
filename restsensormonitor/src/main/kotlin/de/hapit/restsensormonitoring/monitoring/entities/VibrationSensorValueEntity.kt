package de.hapit.restsensormonitoring.monitoring.entities

import de.hapit.restsensormonitoring.monitoring.dtos.CreateVibrationSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.VibrationSensorValueDto
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "vibrationsensor")
internal data class VibrationSensorValueEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
        @NotNull
        @Column(name = "DATETIME_FIELD")
        val datetime: LocalDateTime,
        @NotNull val value: Int) {

    @Suppress("unused")
    private constructor() : this(datetime = LocalDateTime.MIN, value = 0)


    fun toDto(): VibrationSensorValueDto = VibrationSensorValueDto(
            id = this.id!!,
            datetime = this.datetime,
            value = this.value)

    companion object {

        fun fromDto(dto: VibrationSensorValueDto) = VibrationSensorValueEntity(
                id = dto.id,
                datetime = dto.datetime,
                value = dto.value)

        fun fromDto(dto: CreateVibrationSensorValueDto) = VibrationSensorValueEntity(
                id = null,
                datetime = LocalDateTime.now(),
                value = dto.vibrationsensor)

//        fun fromDto(dto: UpdateCityDto, defaultCity: CityEntity) = CityEntity(
//                id = defaultCity.id!!,
//                name = dto.name ?: defaultCity.name,
//                description = dto.description ?: defaultCity.description)
    }


}
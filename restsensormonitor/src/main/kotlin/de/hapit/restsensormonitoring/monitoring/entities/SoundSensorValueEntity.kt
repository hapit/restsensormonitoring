package de.hapit.restsensormonitoring.monitoring.entities

import de.hapit.restsensormonitoring.monitoring.dtos.CreateSoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorValueDto
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "soundsensor")
internal data class SoundSensorValueEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
        @NotNull
        @Column(name = "DATETIME_FIELD")
        val datetime: LocalDateTime,
        @NotNull val avg: Int,
        @NotNull val max: Int) {

    @Suppress("unused")
    private constructor() : this(datetime = LocalDateTime.MIN, avg = 0, max = 0)


    fun toDto(): SoundSensorValueDto = SoundSensorValueDto(
            id = this.id!!,
            datetime = this.datetime,
            avg = this.avg,
            max = this.max)

    companion object {

        fun fromDto(dto: SoundSensorValueDto) = SoundSensorValueEntity(
                id = dto.id,
                datetime = dto.datetime,
                avg = dto.avg,
                max = dto.max)

        fun fromDto(dto: CreateSoundSensorValueDto) = SoundSensorValueEntity(
                id = null,
                datetime = LocalDateTime.now(),
                avg = dto.avg,
                max = dto.max)

//        fun fromDto(dto: UpdateCityDto, defaultCity: CityEntity) = CityEntity(
//                id = defaultCity.id!!,
//                name = dto.name ?: defaultCity.name,
//                description = dto.description ?: defaultCity.description)
    }


}
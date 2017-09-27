package de.hapit.restsensormonitoring.monitoring.services

import de.hapit.restsensormonitoring.monitoring.dtos.CreateSoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.CreateVibrationSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorDto
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.web.client.RestTemplate
import java.net.URI

inline fun <reified T : Any> typeRef(): ParameterizedTypeReference<T> = object : ParameterizedTypeReference<T>() {}

class SensorClient(val sensorRestTemplate: RestTemplate, val soundServiceUrl: String, val vibrationServiceUrl: String) {

    val log = LoggerFactory.getLogger(this.javaClass)

    fun getSoundSensorData(): CreateSoundSensorValueDto {
        val endpoint = URI.create(soundServiceUrl)
        val request = RequestEntity<Any>(HttpMethod.GET, endpoint)

        val respType = object : ParameterizedTypeReference<List<SoundSensorDto>>() {}
        val response = sensorRestTemplate.exchange(request, respType)

        val items: List<SoundSensorDto> = response.body
        return items.get(0).soundsensor
    }

    fun getVibrationSensorData(): CreateVibrationSensorValueDto {

        val endpoint = URI.create(vibrationServiceUrl)
        val request = RequestEntity<Any>(HttpMethod.GET, endpoint)

        val respType = object : ParameterizedTypeReference<List<CreateVibrationSensorValueDto>>() {}
        val response = sensorRestTemplate.exchange(request, respType)

        val items: List<CreateVibrationSensorValueDto> = response.body
        return items.get(0)
    }
}
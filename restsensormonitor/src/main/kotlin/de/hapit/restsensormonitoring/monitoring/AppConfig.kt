package de.hapit.restsensormonitoring.monitoring

import de.hapit.restsensormonitoring.monitoring.crawler.SensorCrawler
import de.hapit.restsensormonitoring.monitoring.services.SensorClient
import de.hapit.restsensormonitoring.monitoring.services.SoundSensorService
import de.hapit.restsensormonitoring.monitoring.services.VibrationSensorService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.client.RestTemplate


@Configuration
@EnableAsync
@EnableScheduling
class AppConfig {

    @Bean
    fun sensorRestTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
        return restTemplateBuilder.build()
    }

    @Bean
    fun sensorClient(sensorRestTemplate: RestTemplate,
                      @Value("\${sensorService.baseUrl}") sensorServiceBaseUrl: String,
                      @Value("\${sensorService.soundPath}") sensorServiceSoundPath: String,
                      @Value("\${sensorService.vibrationPath}") sensorServiceVibrationPath: String
    ): SensorClient {
        return SensorClient(sensorRestTemplate, sensorServiceBaseUrl + sensorServiceSoundPath, sensorServiceBaseUrl + sensorServiceVibrationPath)
    }

    @Bean
    fun sensorCrawler(sensorClient: SensorClient, soundSensorService: SoundSensorService, vibrationSensorService: VibrationSensorService): SensorCrawler {
        return SensorCrawler(sensorClient, soundSensorService, vibrationSensorService)
    }
}
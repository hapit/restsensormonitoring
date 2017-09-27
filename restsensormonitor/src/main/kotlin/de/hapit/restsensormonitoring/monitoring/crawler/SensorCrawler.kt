package de.hapit.restsensormonitoring.monitoring.crawler

import de.hapit.restsensormonitoring.monitoring.services.SensorClient
import de.hapit.restsensormonitoring.monitoring.services.SoundSensorService
import de.hapit.restsensormonitoring.monitoring.services.VibrationSensorService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled


class SensorCrawler(val sensorClient: SensorClient, val soundSensorService: SoundSensorService, val vibrationSensorService: VibrationSensorService) {

    val log = LoggerFactory.getLogger(this.javaClass)

    @Scheduled(fixedRateString = "\${soundsensor.crawler.rate}")
    fun crawlSoundSensorData() {
        try {
            val createSoundSensorValue = sensorClient.getSoundSensorData()

            log.info("crawled data: ${createSoundSensorValue}")

            soundSensorService.addSoundSensorValue(createSoundSensorValue)
        } catch (e: Exception) {
            log.warn("Error while retrieving sound data. ({})", e.message)
        }
    }

    @Scheduled(fixedRateString = "\${vibrationsensor.crawler.rate}")
    fun crawlVibrationSensorData() {
        try {
            val createVibrationSensorValue = sensorClient.getVibrationSensorData()

            log.info("crawled data: ${createVibrationSensorValue}")

            vibrationSensorService.addVibrationSensorValue(createVibrationSensorValue)
        } catch (e: Exception) {
            log.warn("Error while retrieving vibration data. ({})", e.message)
        }
    }

}

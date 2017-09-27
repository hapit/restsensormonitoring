package de.hapit.restsensormonitoring.monitoring.controller

import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.dtos.VibrationSensorValueDto
import de.hapit.restsensormonitoring.monitoring.services.SoundSensorService
import de.hapit.restsensormonitoring.monitoring.services.VibrationSensorService
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RequestMapping("/vibrationsensor")
@RestController
class VibrationSensorController(val vibrationSensorService: VibrationSensorService) {

    val log = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(value="/count", method = arrayOf(RequestMethod.GET))
    fun countVibrationSensorValues(): Long {
        return vibrationSensorService.countVibrationSensorValues()
    }

    @RequestMapping(value="/all", method = arrayOf(RequestMethod.GET))
    fun getAllVibrationSensorValues(): List<VibrationSensorValueDto> {
        return vibrationSensorService.retrieveAllVibrationSensorValues()
    }

    @RequestMapping(value="/after/{time}", method = arrayOf(RequestMethod.GET))
    fun getVibrationSensorValuesAfter(@PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) time: LocalDateTime): List<VibrationSensorValueDto> {
        log.debug("requested values after {}", time.toString())
        return vibrationSensorService.retrieveVibrationSensorValuesAfter(time)
    }

    @RequestMapping(value="/between/{start}/{end}", method = arrayOf(RequestMethod.GET))
    fun getVibrationSensorValuesBetween(
            @PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) start: LocalDateTime,
            @PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) end: LocalDateTime): List<VibrationSensorValueDto> {
        log.debug("requested values between {} and {}", start.toString(), end.toString())
        return vibrationSensorService.retrieveVibrationSensorValuesBetween(start, end)
    }

}
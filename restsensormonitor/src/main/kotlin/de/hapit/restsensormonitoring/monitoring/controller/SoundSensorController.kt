package de.hapit.restsensormonitoring.monitoring.controller

import de.hapit.restsensormonitoring.monitoring.dtos.SoundSensorValueDto
import de.hapit.restsensormonitoring.monitoring.services.SoundSensorService
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RequestMapping("/soundsensor")
@RestController
class SoundSensorController (val soundSensorService: SoundSensorService) {

    val log = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(value="/count", method = arrayOf(RequestMethod.GET))
    fun countSoundSensorValues(): Long {
        return soundSensorService.countSoundSensorValues()
    }

    @RequestMapping(value="/all", method = arrayOf(RequestMethod.GET))
    fun getAllSoundSensorValues(): List<SoundSensorValueDto> {
        return soundSensorService.retrieveAllSoundSensorValues()
    }

    @RequestMapping(value="/after/{time}", method = arrayOf(RequestMethod.GET))
    fun getSoundSensorValuesAfter(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) time: LocalDateTime): List<SoundSensorValueDto> {
        log.debug("requested values after {}", time.toString())
        return soundSensorService.retrieveSoundSensorValuesAfter(time)
    }

    @RequestMapping(value="/between/{start}/{end}", method = arrayOf(RequestMethod.GET))
    fun getSoundSensorValuesBetween(
            @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) start: LocalDateTime,
            @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) end: LocalDateTime): List<SoundSensorValueDto> {
        log.debug("requested values between {} and {}", start.toString(), end.toString())
        return soundSensorService.retrieveSoundSensorValuesBetween(start, end)
    }

}
package de.hapit.restsensormock.restsensormock.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/soundsensor")
class SoundsensorController {

    var avgValue = 350
    var maxValue = 100
    var avgChange = 10
    var maxChange = 30

    @RequestMapping(value = "/v1/data", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    fun getEmployeeInJSON(): String {
        nextValues()
        return "[{\"soundsensor\":{\"avg\":${avgValue},\"max\":${maxValue}}}]"

    }

    private fun nextValues() {
        if (avgValue > 650) {
            avgChange *= -1
        }
        if (avgValue < 350) {
            avgChange *= -1
        }
        if (maxValue > 900) {
            maxChange *= -1
        }
        if (maxValue < 100) {
            maxChange *= -1
        }
        avgValue += avgChange
        maxValue += maxChange
    }
}
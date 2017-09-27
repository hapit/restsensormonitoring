package de.hapit.restsensormock.restsensormock.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vibrationsensor")
class VibrationsensorController {

    var value = 200
    var change = 25

    @RequestMapping(value = "/v1/data", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    fun getEmployeeInJSON(): String {
        nextValue()

        return "[{\"vibrationsensor\":${value}}]"
    }


    private fun nextValue() {
        if (value > 800) {
            change *= -1
        }
        if (value < 200) {
            change *= -1
        }
        value += change
    }
}
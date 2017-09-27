package de.hapit.restsensormonitoring.monitoring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MonitoringApplication

fun main(args: Array<String>) {
    SpringApplication.run(MonitoringApplication::class.java, *args)
}

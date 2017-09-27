package de.hapit.restsensormonitoring.monitoring.converter

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class LocalDateTimeAttributeConverter : AttributeConverter<LocalDateTime, Timestamp>{
    override fun convertToDatabaseColumn(locDateTime: LocalDateTime?): Timestamp {
        return Timestamp.valueOf(locDateTime!!)
    }

    override fun convertToEntityAttribute(sqlTimestamp: Timestamp?): LocalDateTime {
        return sqlTimestamp!!.toLocalDateTime()
    }
}
package uk.co.kenfos.json.serdes

import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes

object JsonSerdes {
    fun <TYPE> from(type: Class<TYPE>): Serde<TYPE> = Serdes.serdeFrom(JsonSerializer<TYPE>(), JsonDeserializer(type))
}
package uk.co.kenfos.json.serdes

import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes
import uk.co.kenfos.json.Json

object JsonSerdes {
    fun <TYPE> from(type: Class<TYPE>): Serde<TYPE> = Serdes.serdeFrom(JsonSerializer<TYPE>(), JsonDeserializer(type))
    fun Json() = from(Json::class.java)
}
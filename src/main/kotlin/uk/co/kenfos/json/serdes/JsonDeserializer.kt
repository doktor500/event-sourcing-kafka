package uk.co.kenfos.json.serdes

import org.apache.kafka.common.serialization.Deserializer
import uk.co.kenfos.json.DefaultObjectMapper

class JsonDeserializer<TYPE>(private val deserializedClass: Class<TYPE>): DefaultObjectMapper(), Deserializer<TYPE> {
    override fun deserialize(topic: String, bytes: ByteArray): TYPE {
        return mapper.readValue(bytes, deserializedClass)
    }
}
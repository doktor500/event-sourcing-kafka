package uk.co.kenfos.json.serdes

import org.apache.kafka.common.serialization.Serializer
import uk.co.kenfos.json.DefaultObjectMapper

class JsonSerializer<TYPE> : DefaultObjectMapper(), Serializer<TYPE> {
    override fun serialize(topic: String, value: TYPE): ByteArray {
        return mapper.writeValueAsBytes(value)
    }
}
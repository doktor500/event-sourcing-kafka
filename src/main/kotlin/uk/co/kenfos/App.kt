package uk.co.kenfos

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.connect.json.JsonSerializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Consumed
import java.util.*

class App {

    private val APPLICATION_ID = UUID.randomUUID().toString()
    private val BOOTSTRAP_SERVERS = "localhost:9092"
    private val EVENT_STREAM_NAME = "stream-events"

    private val builder = StreamsBuilder()

    fun main() {
        val events = builder.stream(EVENT_STREAM_NAME, Consumed.with(Serdes.String(), Serdes.String()))
        events.foreach { _, value -> println(value) }
        KafkaStreams(builder.build(), properties()).start()
    }

    private fun properties(): Properties {
        return Properties().apply {
            this[StreamsConfig.APPLICATION_ID_CONFIG] = APPLICATION_ID
            this[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = BOOTSTRAP_SERVERS
            this["group.id"] = APPLICATION_ID
            this["key.serializer"] = StringSerializer::class.java.name
            this["value.serializer"] = JsonSerializer::class.java.name
        }
    }
}

fun main() {
    App().main()
}

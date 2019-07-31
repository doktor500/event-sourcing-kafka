package uk.co.kenfos

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.common.utils.Bytes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.kstream.Produced
import org.apache.kafka.streams.state.KeyValueStore
import uk.co.kenfos.domain.Message
import uk.co.kenfos.domain.TaskSummary
import uk.co.kenfos.json.EventParser
import uk.co.kenfos.json.TaskSummaryJson
import uk.co.kenfos.json.serdes.JsonSerdes
import java.util.*

class App {
    private val applicationId = "tasks"
    private val inputStream = "input-events"
    private val outputStream = "output-tasks"
    private val aggregatedTasks = "aggreegated-tasks"
    private val bootstrapServers = "localhost:9092"

    private val builder = StreamsBuilder()
    private val eventParser = EventParser()

    fun main() {
        builder.stream(inputStream, Consumed.with(Serdes.String(), JsonSerdes.from(Message::class.java)))
            .mapValues { message -> eventParser.parse(message.eventType, message.value) }
            .groupByKey()
            .aggregate({ TaskSummary.empty }, { id, event, summary -> summary.update(id, event) }, materialized())
            .mapValues { summary -> TaskSummaryJson(summary) }
            .toStream()
            .to(outputStream, Produced.with(Serdes.String(), JsonSerdes.from(TaskSummaryJson::class.java)))

        KafkaStreams(builder.build(), properties()).start()
    }

    private fun materialized(): Materialized<String, TaskSummary, KeyValueStore<Bytes, ByteArray>> {
        return Materialized.`as`<String, TaskSummary, KeyValueStore<Bytes, ByteArray>>(aggregatedTasks)
            .withKeySerde(Serdes.String())
            .withValueSerde(JsonSerdes.from(TaskSummary::class.java))
    }

    private fun properties(): Properties {
        return Properties().apply {
            this["group.id"] = applicationId
            this[StreamsConfig.APPLICATION_ID_CONFIG] = applicationId
            this[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        }
    }
}

fun main() {
    App().main()
}

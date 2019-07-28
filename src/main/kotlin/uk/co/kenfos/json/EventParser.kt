package uk.co.kenfos.json

import uk.co.kenfos.domain.Event
import uk.co.kenfos.domain.Event.TaskAssigned
import uk.co.kenfos.domain.Event.TaskReceived

class EventParser : DefaultObjectMapper() {
    private val taskReceived = "task-received"
    private val taskAssigned = "task-assigned"

    fun parse(eventType: String, payload: String): Event {
        return when (eventType) {
            taskReceived -> parse(payload, TaskReceived::class.java)
            taskAssigned -> parse(payload, TaskAssigned::class.java)
            else -> throw IllegalArgumentException()
        }
    }

    private fun <TYPE> parse(payload: String, type: Class<TYPE>): TYPE {
        return mapper.readValue(payload, type)
    }
}
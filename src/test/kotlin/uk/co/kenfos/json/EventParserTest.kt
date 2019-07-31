package uk.co.kenfos.json

import uk.co.kenfos.domain.Event
import uk.co.kenfos.domain.Event.TaskAssigned
import uk.co.kenfos.domain.Event.TaskReceived
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.fail

class EventParserTest {

    private val eventParser = EventParser()

    @Test fun `task received event can be parsed`() {
        val payload = """{"title": "Investigate how to use event sourcing with Kafka"}"""
        val event: Event = eventParser.parse("task-received", payload)
        when (event) {
            is TaskReceived -> assertEquals(event.title, "Investigate how to use event sourcing with Kafka")
            else -> fail("task-received event can not be parsed")
        }
    }

    @Test fun `task assigned event can be parsed`() {
        val payload = """{"name": "David"}"""
        val event: Event = eventParser.parse("task-assigned", payload)
        when (event) {
            is TaskAssigned -> assertEquals(event.name, "David")
            else -> fail("task-assigned event can not be parsed")
        }
    }

    @Test fun `unrecognized event can not be parsed`() {
        val payload = """{"title": "Water the plants"}"""
        assertFailsWith<IllegalArgumentException> {
            eventParser.parse("invalid-type", payload)
        }
    }
}
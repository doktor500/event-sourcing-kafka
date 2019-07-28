package uk.co.kenfos.domain

import uk.co.kenfos.domain.Event.TaskAssigned
import uk.co.kenfos.domain.Event.TaskReceived

data class Summary(val id: String, val description: String) {
    companion object {
        val empty = Summary("", "")
    }

    fun update(id: String, event: Event): Summary {
        return when (event) {
            is TaskReceived -> Summary(id, event.title)
            is TaskAssigned -> Summary(id, "Task: '$description' is assigned to: '${event.name}'")
        }
    }
}
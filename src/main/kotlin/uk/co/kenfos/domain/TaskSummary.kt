package uk.co.kenfos.domain

import uk.co.kenfos.domain.Event.TaskAssigned
import uk.co.kenfos.domain.Event.TaskReceived

data class TaskSummary(val id: String, val description: String) {
    companion object {
        val empty = TaskSummary("", "")
    }

    fun update(id: String, event: Event): TaskSummary {
        return when (event) {
            is TaskReceived -> TaskSummary(id, event.title)
            is TaskAssigned -> TaskSummary(id, "Task: '$description' is assigned to: '${event.name}'")
        }
    }
}
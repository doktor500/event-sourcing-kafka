package uk.co.kenfos.domain

import uk.co.kenfos.domain.Event.TaskAssigned
import uk.co.kenfos.domain.Event.TaskReceived
import uk.co.kenfos.json.Field
import uk.co.kenfos.json.Json
import uk.co.kenfos.json.JsonSchema

data class TaskSummary(val id: String, val description: String) {
    companion object {
        val empty = TaskSummary("", "")
    }

    fun update(id: String, event: Event): TaskSummary {
        return when (event) {
            is TaskReceived -> TaskSummary(id, event.title)
            is TaskAssigned -> TaskSummary(id, "Task: '${description()}' is assigned to: '${event.name}'")
        }
    }

    private fun description(): String {
        return when {
            description.contains("'") -> description.split("'")[1]
            else -> description
        }
    }
}

fun TaskSummary.toJson() = Json(this, schema)

val schema = JsonSchema.with(
    Field(field = "id", type = "string"),
    Field(field = "description", type = "string")
)
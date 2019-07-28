package uk.co.kenfos.json

import uk.co.kenfos.domain.Summary

data class TaskJsonSchema(val payload: Summary, val schema: Schema = taskSchema)
data class Schema(val type: String, val fields: List<Field>)
data class Field(val field: String, val type: String)

private val fields = listOf(Field(field = "id", type = "string"), Field(field = "description", type = "string"))
private val taskSchema = Schema("struct", fields)

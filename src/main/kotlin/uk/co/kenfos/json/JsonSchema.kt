package uk.co.kenfos.json

data class Schema(val type: String, val fields: List<Field>)
data class Field(val field: String, val type: String)

object JsonSchema {
    fun with(vararg fields: Field): Schema {
        return Schema("struct", fields.asList())
    }
}

data class Json(val payload: Any, val schema: Schema)
package uk.co.kenfos.domain

data class Message(val id: Long, val taskId: Long, val eventType: String, val value: String, val dateCreated: Long)
package uk.co.kenfos.domain

sealed class Event {
    data class TaskAssigned(val name: String): Event()
    data class TaskReceived(val title: String): Event()
}
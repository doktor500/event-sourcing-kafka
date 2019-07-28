package uk.co.kenfos.domain

import uk.co.kenfos.domain.Event.*
import kotlin.test.Test
import kotlin.test.assertEquals

class SummaryTest {

    @Test fun `summary can be updated`() {
        val emptySummary = Summary.empty
        val summary = emptySummary.update(1, TaskReceived(title = "Learn kafka"))
        val updatedSummary = summary.update(1, TaskAssigned(name = "David"))

        assertEquals(Summary(1, "Task: 'Learn kafka' is assigned to: 'David'"), updatedSummary)
    }
}
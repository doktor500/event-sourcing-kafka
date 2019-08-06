package uk.co.kenfos.domain

import uk.co.kenfos.domain.Event.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TaskSummaryTest {

    @Test fun `task summary can be updated`() {
        val emptyTaskSummary = TaskSummary.empty
        val taskSummary = emptyTaskSummary.update("1", TaskReceived(title = "Learn kafka"))
        val updatedTaskSummary = taskSummary.update("1", TaskAssigned(name = "David"))

        assertEquals(TaskSummary("1", "Task: 'Learn kafka' is assigned to: 'David'"), updatedTaskSummary)
    }

    @Test fun `task summary can be assigned multiple times`() {
        val emptyTaskSummary = TaskSummary.empty
        val taskSummary = emptyTaskSummary.update("1", TaskReceived(title = "Learn kafka"))
        val updatedTaskSummary1 = taskSummary.update("1", TaskAssigned(name = "David"))
        val updatedTaskSummary2 = updatedTaskSummary1.update("1", TaskAssigned(name = "Sara"))

        assertEquals(TaskSummary("1", "Task: 'Learn kafka' is assigned to: 'Sara'"), updatedTaskSummary2)
    }
}
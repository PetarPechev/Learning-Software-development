package com.company;

import java.time.LocalDate;

public class Task extends BoardItem{
    private static final int ASSIGNEE_MIN_LENGTH = 5;
    private static final int ASSIGNEE_MAX_LENGTH = 30;
    private static final Status TASK_INITIAL_STATUS = Status.TODO;
    private String assignee;
    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate);
        status = TASK_INITIAL_STATUS;

        validateAssignee(assignee);
        this.assignee = assignee;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee (String assignee) {
        validateAssignee(assignee);

        logEvent(String.format("Assignee changed from %s to %s", getAssignee(), assignee));

        this.assignee = assignee;
    }

    private void validateAssignee(String assignee) {
        if (assignee.length() < ASSIGNEE_MIN_LENGTH || assignee.length() > ASSIGNEE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Please provide a title with length between %d and %d chars",
                    ASSIGNEE_MIN_LENGTH, ASSIGNEE_MAX_LENGTH));
        }
    }
}

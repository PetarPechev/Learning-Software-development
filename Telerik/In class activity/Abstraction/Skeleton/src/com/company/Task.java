package com.company;

import java.time.LocalDate;

public class Task extends BoardItem {
    private static final Status INITIAL_STATUS = Status.TODO;
    private static final Status FINAL_STATUS = Status.VERIFIED;
    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, INITIAL_STATUS);
        this.assignee = assignee;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        if (assignee.length() < 5 || assignee.length() > 30) {
            throw new IllegalArgumentException();
        }

        logEvent(String.format("Assignee changed from %s to %s", getAssignee(), assignee));

        this.assignee = assignee;
    }

    @Override
    public void revertStatus() {
        if (getStatus() != INITIAL_STATUS){
            Status status = Status.values()[getStatus().ordinal() - 1];
            logEvent(String.format("Task status changed from %s to %s", getStatus(), status));

            setStatus(status);
        } else {
            logEvent(String.format("Can't revert, already at %s", INITIAL_STATUS));
        }
    }

    @Override
    public void advanceStatus() {
        if (getStatus() != FINAL_STATUS){
            Status status = Status.values()[getStatus().ordinal() + 1];
            logEvent(String.format("Task status changed from %s to %s", getStatus(), status));

            setStatus(status);
        } else {
            logEvent(String.format("Can't advance, already at %s", FINAL_STATUS));
        }
    }
}

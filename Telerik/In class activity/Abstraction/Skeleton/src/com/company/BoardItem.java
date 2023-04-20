package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class BoardItem {

    private static final int TITLE_MIN_LENGTH = 5;
    private static final int TITLE_MAX_LENGTH = 30;
    private static final Status INITIAL_STATUS = Status.OPEN;


    private String title;
    private Status status;
    private LocalDate dueDate;
    private final List<EventLog> history = new ArrayList<>();

    public BoardItem(String title, LocalDate dueDate) {
        this(title, dueDate, INITIAL_STATUS);
    }

    protected BoardItem(String title, LocalDate dueDate, Status status) {
        validateDueDate(dueDate);
        validateTitle(title);

        this.title = title;
        this.dueDate = dueDate;
        this.status = status;

        logEvent(String.format("Item created: %s", viewInfo()));
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);

        logEvent(String.format("Title changed from %s to %s", getTitle(), title));

        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);

        logEvent(String.format("DueDate changed from %s to %s", getDueDate(), dueDate));

        this.dueDate = dueDate;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public abstract void revertStatus();

    public abstract void advanceStatus();

    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }

    public void displayHistory() {
        for (EventLog log : history) {
            System.out.println(log.viewInfo());
        }
    }

    protected void logEvent(String event) {
        history.add(new EventLog(event));
    }

    private void validateTitle(String title) {
        if (title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Please provide a title with length between %d and %d chars",
                    TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
    }

    private void validateDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("DueDate can't be in the past");
        }
    }

}

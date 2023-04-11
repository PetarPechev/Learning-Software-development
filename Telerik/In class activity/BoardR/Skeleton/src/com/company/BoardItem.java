package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {

    private static final int TITLE_MIN_LENGTH = 5;
    private static final int TITLE_MAX_LENGTH = 30;
    private static final Status INITIAL_STATUS = Status.OPEN;
    private static final Status FINAL_STATUS = Status.VERIFIED;

    private String title;
    protected Status status;
    private LocalDate dueDate;
    protected final List<EventLog> history = new ArrayList<>();

    public BoardItem(String title, LocalDate dueDate) {
        validateTitle(title);
        validateDueDate(dueDate);

        this.title = title;
        this.dueDate = dueDate;
        this.status = INITIAL_STATUS;

        logEvent(String.format("Item created: %s", viewInfo()));
    }


    /**
     * Returns the current status of the task.
     * @return the status of the task
     * @author Petar Pechev
     */
    public Status getStatus() {
        return status;
    }


    /**
     * Returns the current title of the task.
     * @return the title of the task
     * @author Petar Pechev
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title of the task to the specified value.
     *
     * @param title the new title of the task
     * @author Petar Pechev
     */
    public void setTitle(String title) {
        validateTitle(title);

        logEvent(String.format("Title changed from %s to %s", getTitle(), title));

        this.title = title;
    }


    /**
     * Returns the current due date of the task.
     *
     * @return the due date of the task as a LocalDate
     * @author Petar Pechev
     */
    public LocalDate getDueDate() {
        return dueDate;
    }


    /**
     * Changes the due date of the task to the specified LocalDate object.
     * This method first validates the new due date using the "validateDueDate" method to ensure that it is not in
     * the past. If the new due date is valid, it logs an event indicating the previous and new due dates of the task
     * before changing its due date to the specified LocalDate object.
     *
     * @param dueDate the new due date of the task
     * @throws IllegalArgumentException if the new due date is in the past
     * @author Petar Pechev
     */
    public void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);

        logEvent(String.format("DueDate changed from %s to %s", getDueDate(), dueDate));

        this.dueDate = dueDate;
    }


    /**
     * Changes the status of the task to the specified Status object.
     * This method logs an event indicating the previous and new status of the task before changing its status
     * to the specified Status object. This method does not perform any validation on the new status value,
     * so it is the responsibility of the calling code to ensure that a valid Status object is provided.
     *
     * @param status the new status of the task
     * @author Petar Pechev
     */
    private void setStatus(Status status) {
        logEvent(String.format("Status changed from %s to %s", getStatus(), status));

        this.status = status;
    }


    /**
     * Reverts the status of the task to the previous status in the Status enum.
     * This method checks if the current status of the task is the INITIAL_STATUS. If it is, it logs a message
     * and does not change the status. Otherwise, it reverts the status of the task to the previous status in
     * the Status enum by calling the "setStatus" method with the previous Status object.
     *
     * @author Petar Pechev
     */
    public void revertStatus() {
        if (status != INITIAL_STATUS) {
            setStatus(Status.values()[status.ordinal() - 1]);
        } else {
            logEvent(String.format("Can't revert, already at %s", getStatus()));
        }
    }


    /**
     * Advances the status of the task to the next status in the Status enum.
     * This method checks if the current status of the task is the FINAL_STATUS. If it is, it logs a message
     * and does not change the status. Otherwise, it advances the status of the task to the next status in
     * the Status enum by calling the "setStatus" method with the next Status object.
     *
     * @author Petar Pechev
     */
    public void advanceStatus() {
        if (status != FINAL_STATUS) {
            setStatus(Status.values()[status.ordinal() + 1]);
        } else {
            logEvent(String.format("Can't advance, already at %s", getStatus()));
        }
    }


    /**
     * Returns a string representation of the EventLog object's information.
     * This method formats and returns a string that includes the title, status, and due date of the EventLog object.
     * The format of the string is "'{title}', [{status} | {dueDate}]".
     *
     * @return a string representation of the EventLog object's information
     * @author Petar Pechev
     */
    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }


    /**
     * Prints the information of each event in the "history" list to the console.
     * This method iterates over the "history" list and calls the "viewInfo" method on each EventLog object to obtain
     * a string representation of the event information. It then prints this string to the console.
     *
     * @author Petar Pechev
     */
    public void displayHistory() {
        for (EventLog log : history) {
            System.out.println(log.viewInfo());
        }
    }


    /**
     * Logs a new event by adding a new EventLog object to the history list.
     *
     * @param event the event description to log
     * @author Petar Pechev
     */
    protected void logEvent(String event) {
        history.add(new EventLog(event));
    }


    /**
     * Validates the length of the title.
     *
     * @param title the title to validate
     * @throws IllegalArgumentException if the title is shorter than TITLE_MIN_LENGTH or longer than TITLE_MAX_LENGTH
     * @author Petar Pechev
     */
    private void validateTitle(String title) {
        if (title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Please provide a title with length between %d and %d chars",
                    TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
    }

    /**
     * Validates that the due date is not in the past.
     *
     * @param dueDate the due date to validate
     * @throws IllegalArgumentException if the due date is before the current date
     * @author Petar Pechev
     */
    private void validateDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("DueDate can't be in the past");
        }
    }

}

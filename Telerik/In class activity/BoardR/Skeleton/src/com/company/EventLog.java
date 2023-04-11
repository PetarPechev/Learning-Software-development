package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");

    private final String description;
    private final LocalDateTime timestamp;

    public EventLog() {
        throw new IllegalArgumentException("Description cannot be empty");
    }

    public EventLog(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Returns the description of the task.
     *
     * @return the description of the task
     * @author Petar Pechev
     */
    public String getDescription() {
        return description;
    }


    /**
     * Returns a string representation of the task's information.
     * The information includes the timestamp when the task was created and the task's description.
     *
     * @return a string representation of the task's information
     *
     * @author Petar Pechev
     */
    public String viewInfo() {
        return String.format("[%s] %s", timestamp.format(formatter), description);
    }

}

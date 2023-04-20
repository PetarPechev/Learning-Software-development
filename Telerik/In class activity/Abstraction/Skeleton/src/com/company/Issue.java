package com.company;

import java.time.LocalDate;

public class Issue extends BoardItem {
    private static final Status INITIAL_STATUS = Status.OPEN;
    private static final Status FINAL_STATUS = Status.VERIFIED;
    private final String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, INITIAL_STATUS);

        if (description.isEmpty()) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void revertStatus() {
        if (getStatus() != INITIAL_STATUS){
            setStatus(INITIAL_STATUS);
            logEvent(String.format("Issue status set to %s", INITIAL_STATUS));
        } else {
            logEvent(String.format("Issue status already %s", INITIAL_STATUS));
        }
    }

    @Override
    public void advanceStatus() {
        if (getStatus() != Status.VERIFIED){
            setStatus(Status.VERIFIED);
            logEvent(String.format("Issue status set to %s", FINAL_STATUS));
        } else {
            logEvent(String.format("Issue status already %s", FINAL_STATUS));
        }
    }
}

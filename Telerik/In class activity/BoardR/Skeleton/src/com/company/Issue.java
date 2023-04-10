package com.company;

import java.time.LocalDate;

public class Issue extends BoardItem{
    private final String description;
    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate);
        this.description = description.isEmpty() ? "No description" : description;
    }

}

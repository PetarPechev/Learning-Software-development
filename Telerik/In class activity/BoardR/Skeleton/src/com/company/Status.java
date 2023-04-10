package com.company;

public enum Status {
    OPEN,
    TODO,
    IN_PROGRESS,
    DONE,
    VERIFIED;

    @Override
    public String toString() {
        switch (this) {
            case OPEN:
                return "Open";
            case VERIFIED:
                return "Verified";
            case DONE:
                return "Done";
            case TODO:
                return "To Do";
            case IN_PROGRESS:
                return "In Progress";
            default:
                return "Unknown";
        }
    }
}

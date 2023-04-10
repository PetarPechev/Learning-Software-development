import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    private final String description;
    private  final LocalDateTime timestamp;

    public EventLog(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        this.description = description;
        timestamp = LocalDateTime.now();
    }

    public EventLog() {
        throw new IllegalArgumentException("Description cannot be empty");
    }


    /**
     * Returns the description of the task.
     *
     * @return the description of the task
     *
     * @author Petar Pechev
     */
    public String getDescription() {
        return description;
    }


    /**
     * Returns the timestamp when the task was created.
     *
     * @return the timestamp when the task was create
     *
     * @author Petar Pechev
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");

        return String.format("[%s] %s", formatter.format(getTimestamp()), getDescription());
    }
}

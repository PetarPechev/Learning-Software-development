import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class BoardItem {

    private static final int TITLE_MIN_LENGTH = 5;
    private static final int TITLE_MAX_LENGTH = 30;


    private String title;
    private LocalDate dueDate;
    private Status status;
    private final List<EventLog> eventsHistory;

    public BoardItem(String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.OPEN;
        eventsHistory = new ArrayList<>();

        addEventToHistory(String.format("Item created: %s", viewInfo()));
    }


    /**
     * Sets the title of the task to the specified value. The method first checks if the new
     * title has a valid length (between TITLE_MIN_LENGTH and TITLE_MAX_LENGTH), and throws
     * an IllegalArgumentException if it doesn't. If the task already has a due date, the
     * method adds an event to the history indicating that the title has been changed.
     *
     * @param title the new title of the task
     *
     * @throws IllegalArgumentException if the length of the title is invalid
     *
     * @author Petar Pechev
     */
    public void setTitle(String title) {
        if (title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH) {
            String errorMessage = String.format("Please provide a title with length between %d and %d chars!", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);
            throw new IllegalArgumentException(errorMessage);
        }

        if (this.dueDate != null) {
            addEventToHistory(String.format("Title changed from %s to %s", this.title, title));
        }

        this.title = title;
    }


    /**
     * Returns the title of the task.
     *
     * @return the title of the task
     *
     * @author Petar Pechev
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the due date of the task to the specified value. The method first checks if the
     * due date is in the future, and throws an IllegalArgumentException if it's not. If
     * the task already has a due date, the method adds an event to the history indicating
     * that the due date has been changed.
     *
     * @param dueDate the new due date of the task
     *
     * @throws IllegalArgumentException if the due date is in the past
     *
     * @author Petar Pechev
     */
    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Please provide a date in the future!");
        }

        if (this.dueDate != null) {
            addEventToHistory(String.format("DueDate changed from %s to %s", this.dueDate, dueDate));
        }

        this.dueDate = dueDate;
    }


    /**
     * Returns the due date of the task.
     *
     * @return the due date of the task
     *
     * @author Petar Pechev
     */
    public LocalDate getDueDate() {
        return dueDate;
    }


    /**
     * Returns the current status of the task.
     *
     * @return the current status of the task
     *
     * @author Petar Pechev
     */
    public Status getStatus() {
        return status;
    }


    /**
     * Reverts the current status to the previous one and adds an event to the history.
     * If the current status is already at the lowest value, it adds an event indicating that
     * the status cannot be reverted. The method returns the updated status.
     *
     * @return the updated "Status" object after the revert operation
     *
     * @author Petar Pechev
     */
    public Status revertStatus() {

        if (status.ordinal() > 0){
            addEventToHistory(String.format("Status changed from %s to %s", status, Status.values()[status.ordinal()- 1]));
        } else {
            addEventToHistory(String.format("Can't revert, already at %s", status));
        }

        status = status.ordinal() == 0 ? status : Status.values()[status.ordinal() - 1];

        return status;
    }


    /**
     * Advances the current status to the next one and adds an event to the history.
     * If the current status is already at the highest value, it adds an event indicating that
     * the status cannot be advanced. The method returns the updated status.
     *
     * @return the updated "Status" object after the advance operation
     *
     * @author Petar Pechev
     */
    public Status advanceStatus() {
        if (status.ordinal() < Status.values().length - 1){
            addEventToHistory(String.format("Status changed from %s to %s", status, Status.values()[status.ordinal()+ 1]));
        } else {
            addEventToHistory(String.format("Can't advance, already at %s", status));
        }

        status = status.ordinal() == Status.values().length - 1 ? status : Status.values()[status.ordinal() + 1];

        return status;
    }


    /**
     * Returns a string representation of the task's information, including its title,
     * status, and due date. The information is formatted as "'title', [status | due date]"
     *
     * @return a string representation of the task's information
     *
     * @author Petar Pechev
     */
    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }

    /**
     * Adds a new event to the history with the specified description. The method creates
     * a new "EventLog" object and adds it to the "eventsHistory" list.
     *
     * @param description the description of the event to be added
     **
     * @author Petar Pechev
     */
    private void addEventToHistory(String description) {
        EventLog newEvent = new EventLog(description);
        eventsHistory.add(newEvent);
    }


    /**
     * Prints the information of each event in the "eventsHistory" list to the console.
     * The method uses a lambda expression to iterate over the list and call the "viewInfo()"
     * method of each "EventLog" object to obtain its information.
     **
     * @author Petar Pechev
     */
    public void displayHistory() {
        eventsHistory.forEach(event -> System.out.println(event.viewInfo()));
    }

}

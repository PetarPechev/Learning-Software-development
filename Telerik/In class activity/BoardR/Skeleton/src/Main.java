import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventLog log = new EventLog("An important thing happened");
        System.out.println(log.getDescription());
        System.out.println(log.viewInfo());

        EventLog log2 = new EventLog();

        Math.max(5, 6);

    }
}

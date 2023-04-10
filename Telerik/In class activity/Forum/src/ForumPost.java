import java.util.ArrayList;
import java.util.List;

public class ForumPost {
    String author;
    String text;
    int upVotes;

    List<String> replies;

    public ForumPost(String author, String text, int upVotes) {
        this.author = author;
        this.text = text;
        this.upVotes = upVotes;
        this.replies = new ArrayList<>();
    }

    public ForumPost(String author, String text) {
        this(author, text, 0);
    }

    public String format() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s / by %s, %d votes.", text, author, upVotes)).append(System.lineSeparator());

        replies.forEach(reply -> sb.append(String.format("- %s", reply)).append(System.lineSeparator()));

        sb.append(System.lineSeparator());

        return sb.toString();
    }


}

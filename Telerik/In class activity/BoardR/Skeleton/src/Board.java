import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardItem> items;

    public Board() {

        this.items = new ArrayList<>();
    }

    /**
     * Returns the number of elements in this list.
     * If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.)
     *
     * @return the count of items inside the Board.
     *
     * @author Petar Pechev
     */
    public int totalItems() {
        return items.size();
    }


    /**
     * When a specified element is not contained in the list, append it to the end of this list.
     *
     * @param item e – element to be appended to this list.
     *
     * @throws IllegalArgumentException - if this item is already in the list
     *
     * @author Petar Pechev
     */
    public void addItem(BoardItem item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException(item.getTitle() + " already in the list");
        } else {
            items.add(item);
        }
    }
}

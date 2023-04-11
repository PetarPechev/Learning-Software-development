package com.company;

import java.util.ArrayList;

public class Board {

    private final ArrayList<BoardItem> items;

    public Board() {
        items = new ArrayList<>();
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
            throw new IllegalArgumentException("Item already in the list");
        }
        items.add(item);
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

}

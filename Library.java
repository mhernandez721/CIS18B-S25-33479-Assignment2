package libraryproject;

import java.util.ArrayList;
import java.util.List;
//Item Library Singleton
class Library {
    private static Library instance;
    private List<Item> items;

    private Library() {
        items = new ArrayList<>();
    }

    // Method for singleton instance
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    //Add items to Library
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added to Library: " + item.getTitle());
    }

    //Show list of items
    public void listAvailableItems() {
        System.out.println("\nAvailable Library Items:");
        for (Item item : items) {
            if (item instanceof IBorrowable && ((IBorrowable) item).isBorrowed()) {
                continue;
            }
            item.displayInfo();
        }
    }

    //Finds items by title
    public Item findItemByTitle(String title) {
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}

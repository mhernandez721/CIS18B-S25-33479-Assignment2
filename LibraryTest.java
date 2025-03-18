package libraryproject;


public class LibraryTest {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        
        // Using Factory to create items
        Item book1 = LibraryItemFactory.createItem("book", "Java Basics", 2019, "Alice Brown");
        Item book2 = LibraryItemFactory.createItem("book", "Advanced Java", 2021, "Bob Smith");
        Item magazine1 = LibraryItemFactory.createItem("magazine", "Tech Monthly", 2023, "10");
        
        // Adding items to Library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);
        
        // Borrowing a book
        System.out.println("\nBorrowing 'Java Basics'...");
        ((Book) book1).borrowItem("Charlie");
        
        // Listing available items
        System.out.println("\nAvailable Items in the Library:");
        library.listAvailableItems();
        
        // Returning the book
        System.out.println("\nReturning 'Java Basics'...");
        ((Book) book1).returnItem();
        
        // Searching for an item
        System.out.println("\nSearching for 'Advanced Java'...");
        Item foundItem = library.findItemByTitle("Advanced Java");
        if (foundItem != null) {
            System.out.println("Item found:");
            foundItem.displayInfo();
        } else {
            System.out.println("Item not found.");
        }
    }
}

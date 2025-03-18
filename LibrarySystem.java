package libraryproject;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Creating items using the factory
        Item book1 = LibraryItemFactory.createItem("book", "Java Programming", 2020, "John Doe");
        Item book2 = LibraryItemFactory.createItem("book", "Data Structures", 2018, "Jane Smith");
        Item magazine1 = LibraryItemFactory.createItem("magazine", "Tech Today", 2021, "5");

        // Adding items to the library
        if (book1 != null) library.addItem(book1);
        if (book2 != null) library.addItem(book2);
        if (magazine1 != null) library.addItem(magazine1);

        // Borrowing a book
        System.out.println("\nBorrowing 'Java Programming'...");
        if (book1 instanceof IBorrowable) {
            ((IBorrowable) book1).borrowItem("Alice");
        }

        // Listing available items
        System.out.println("\nAvailable Items in the Library:");
        library.listAvailableItems();

        // Returning a book
        System.out.println("\nReturning 'Java Programming'...");
        if (book1 instanceof IBorrowable) {
            ((IBorrowable) book1).returnItem();
        }

        // Searching for an item
        System.out.print("\nEnter title to search: ");
        String searchTitle = scanner.nextLine();
        Item foundItem = library.findItemByTitle(searchTitle);

        if (foundItem != null) {
            System.out.println("Item found:");
            foundItem.displayInfo();
        } else {
            System.out.println("Item not found.");
        }

        scanner.close();
    }
}

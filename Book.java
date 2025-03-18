package libraryproject;

import java.io.*;

//Start of Book function
class Book extends Item implements IBorrowable, Serializable {
    private static final long serialVersionUID = 1L;
    private String author;
    private String ISBN;
    private String borrower;
    private static final String FILE_NAME = "borrowedBooks.ser";
    
    // Book Info
    public Book(String title, int publicationYear, String author, String ISBN) {
        super(title, publicationYear);
        this.author = author;
        this.ISBN = ISBN;
        this.borrower = null;
    }

    // Gets book info like ISBN and author
    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

   // Borrow Status
    public void borrowItem(String borrower) {
        if (this.borrower == null) {
            this.borrower = borrower;
            System.out.println("'" + getTitle() + "' has been borrowed by " + borrower);
            saveBorrowingState();
        } else {
            System.out.println("Sorry, '" + getTitle() + "' is already borrowed by " + this.borrower);
        }
    }

   // Return status
    public void returnItem() {
        if (this.borrower != null) {
            System.out.println("'" + getTitle() + "' has been returned by " + this.borrower);
            this.borrower = null;
            saveBorrowingState();
        } else {
            System.out.println("'" + getTitle() + "' was not borrowed.");
        }
    }

    
    public boolean isBorrowed() {
        return borrower != null;
    }

    
    public void displayInfo() {
        System.out.println("Book: " + getTitle() + " by " + author + " (ISBN: " + ISBN + ")");
    }
// saves status
    private void saveBorrowingState() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error saving borrowing state: " + e.getMessage());
        }
    }
}

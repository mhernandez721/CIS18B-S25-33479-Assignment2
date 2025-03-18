package libraryproject;

//Base class for all library items
abstract class Item {
 private String title;
 private int publicationYear;

 public Item(String title, int publicationYear) {
     this.title = title;
     this.publicationYear = publicationYear;
 }

 // Gets book details
 public String getTitle() {
     return title;
 }

 public int getPublicationYear() {
     return publicationYear;
 }

 public abstract void displayInfo();
}

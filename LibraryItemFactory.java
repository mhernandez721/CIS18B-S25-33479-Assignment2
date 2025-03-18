package libraryproject;

public class LibraryItemFactory {
	
	//Factory Method to make items
	
    public static Item createItem(String type, String title, int publicationYear, String extraData) {
        if (type.equalsIgnoreCase("book")) {
        	
        	//Makes books with extra data like the author and a generated ISBN
            return new Book(title, publicationYear, extraData, "ISBN_" + Math.abs(title.hashCode())); 
        } else if (type.equalsIgnoreCase("magazine")) {
            try {
            	
            	//Makes issue number for magazines
                int issueNumber = Integer.parseInt(extraData);
                return new Magazine(title, publicationYear, issueNumber);
            }
            //Handles invalid input
            catch (NumberFormatException e) {
                System.out.println("Error: Invalid issue number for magazine '" + title + "'. Using default issue 1.");
                return new Magazine(title, publicationYear, 1);
            }
        }
        //Warns if unknown item type is given
        System.out.println("Warning: Unknown item type '" + type + "'. Returning null.");
        return null;
    }
}
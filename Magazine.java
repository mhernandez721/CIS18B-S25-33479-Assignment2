package libraryproject;

class Magazine extends Item {
    private int issueNumber; //Issue number for magazine

    
    //Initializing Magazine Item
    public Magazine(String title, int publicationYear, int issueNumber) {
        super(title, publicationYear);
        this.issueNumber = issueNumber;
    }

   //show Magazine info
    public void displayInfo() {
        System.out.println("Magazine: " + getTitle() + " (Issue No. " + issueNumber + ")");
    }
}

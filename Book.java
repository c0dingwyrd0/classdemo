
public class Book {	
	private String bookTitle;
	private double bookPrice;
	private double bookWeight;
	private double bookDiscount;
	
	public Book(String bookTitle, double bookPrice, double bookWeight) { //constructor to initialize all instance variables except discount- set to zero.
		this.bookTitle = bookTitle; 
		this.bookPrice = bookPrice;
		this.bookWeight = bookWeight;
		this.bookDiscount = 0.0;
		
	}

	public String getBookTitle() { // Getter for bookTitle variable
		return bookTitle;
	}
	
	public double getBookPrice() { // Getter for bookPrice
		return bookPrice;
	}
	
	public double getBookWeight() { // Getter for bookWeight variable
		return bookWeight;
	}
	
	public double getBookDiscount() {
		return bookDiscount;
	}
	
	
	public void setBookDiscount(double percentDiscount) { //setter method for discount discount entered as a percentage
		this.bookDiscount = this.bookDiscount + (percentDiscount / 100.0); 
	}
	
	public void adjustPrice(double amountDiscounted) { //method than takes an bookPrice type double and adds that amount of money to the book’s price- the amount can be positive or negative as a book’s price may be increased or decreased.
		this.bookPrice -= amountDiscounted;
	}
	
	public double priceAfterDiscount(double discount, double bookPrice) { //method that calc and returns the discounted book’s price after applying the discount
		return this.bookPrice - this.bookDiscount;
	}
	
	public boolean equals(Object bookObject) { //method to test the equality of two books
		if (this == bookObject) {
			return true;
		}
		if (bookObject == null || getClass() != bookObject.getClass()) {
			return false;
		}
		Book book = (Book) bookObject;
		return Double.compare(book.bookWeight, bookWeight) == 0 &&
				Double.compare(book.bookPrice, bookPrice) == 0 &&
				bookTitle.equals(book.bookTitle);
	}
	
	public String toString(String bookTile, double bookWeight, double bookPrice) { //method that returns a nicely formatted string description of the book.
		return "Book Title: " + this.bookTitle + "Book Weight: " + this.bookWeight + "Book Price: $" + this.bookPrice + "Book Discount: " + (this.bookDiscount * 100) + "%"; //format string here
		
	}	
}

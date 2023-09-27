
public class Invoice {
	private String customerName;
	private Book[] customerBooks;
	
	public Invoice(String customerName) { // constructor - takes as input only the customer's name and creates an invoice where the book[] is null.
		this.customerName = customerName; //creates invoice where book[] is null 
		this.customerBooks = new Book[3];
	}
	public double getTotal() { //method that calc and returns the total cost of invoice do not include null books 
		double totalCost = 0; //calc total cost of invoice - do not include null books
		for (Book book : customerBooks) {
			if (book != null) {
				totalCost += book.getBookPrice();
			}
		}
		return totalCost;
	}
	public double getDiscountedTotal() { //method that calcs and returns the total cost of invoice sum of prices (after applying discount) null books not included
		double discountedTotal = 0; 
		for (Book book : customerBooks) { //calc sum of prices after applying discount do not include null books
			if (book != null) {
				double currPrice = book.getBookPrice();
				double currDiscount = book.getBookDiscount();
				discountedTotal += book.priceAfterDiscount(currDiscount, currPrice);
			}
		}	
		return discountedTotal;	//return sum of prices after discount
	}
	
	public double getTotalWeight() { //method that calcs and returns the total weight of all books in this invoice
		double totalBookWeight = 0;
		for (Book book : customerBooks) {//calc total weight of all books in the invoice
			if (book != null) {
				totalBookWeight += book.getBookWeight();
			}
		}
		return totalBookWeight;	// return totalWeight;
	}
	public void addBook(String bookTitle, double bookPrice, double bookWeight) { //takes 3 parameters for title, price, and weight
		for (int i = 0; i < customerBooks.length; i++) {
			if (customerBooks[i] == null) {
				customerBooks[i] = new Book(bookTitle, bookPrice, bookWeight); // creates book object of type Book and adds it to the invoice's book array element
				return;
			}
		}
		
		throw new RuntimeException("Invoice already has 3 books."); //throw exception if 3 books have already been added
	}

	public void adjustPrice(int bookNum, double priceAdjustment) { //method that takes two input, namely bookNum and priceAdjustment, where bookNum is either 1, 2 or 3. The method then adjusts the price of the given book. Note that the method should throw an exception if bookNum is invalid.
		if (bookNum < 1 || bookNum > 3 || customerBooks[bookNum-1] == null) {
			throw new RuntimeException("Book number is invalid."); //throw an exception if bookNum is invalid.
		}
		
		customerBooks[bookNum - 1].adjustPrice(priceAdjustment);
	}
	
	public void applyDiscount(int bookNum, double bookDiscount) {   //method sets discount of one of the invoice's books. The method takes two inputs, namely bookNum and discount, where bookNum is either 1, 2 or 3. The method then sets the specified book’s discount to the input discount value
		if (bookNum < 1 || bookNum > 3 || customerBooks[bookNum -1] == null) {
			throw new RuntimeException("Invalid book number.");    //throw exception if book is bookNum is invalid
		}
		
		customerBooks[bookNum - 1].setBookDiscount(bookDiscount);  //sets discount of one of the invoice's books
	}
	
	public static double calculateTax(double cost, double taxRate) { //static method used to calculate the amount of sales tax to be paid, two input parameters both of type double. The first called cost, the second called taxRate.
		return (cost * taxRate) / 100; //calculates and returns the amount of tax to be paid
	}
	
	
	public String toString() { //method that returns a string representation of the invoice including the following:
		StringBuilder invoiceLayout = new StringBuilder("Customer Name:" + customerName + "\n"); //customer's name
		for (Book book : customerBooks) {
			if (book != null) {
				invoiceLayout.append("Book Title: ").append(book.getBookTitle()).append("\n");
				invoiceLayout.append(book.toString()).append("\n");   //details of the non-null invoice's books
			}
		}
		invoiceLayout.append("Total Book Weight: ").append(getTotalWeight()).append("lbs \n"); //total weight of all books in the invoice
		invoiceLayout.append("Total: $").append(getTotal()).append("\n");  //total before discount
		invoiceLayout.append("Total with discount: $").append(getDiscountedTotal()).append("\n"); //total after discount
			
		double tax = calculateTax(getDiscountedTotal(), 4.5); //amount of tax to be paid where the tax is calculated based on the discounted invoice's total
			
		invoiceLayout.append("Taxes at 4.5%: $").append(tax).append("\n");
		invoiceLayout.append("Overall Cost: $").append(getDiscountedTotal() + tax).append("\n"); //the overall cost which is equal to discounted total + tax 
			
		return invoiceLayout.toString();
		
	}

}

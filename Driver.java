

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // Create scanner to get input

        System.out.print("Enter Customer Name:"); // 1st customer name from user and assigns to variable
        String customerName1 = scnr.nextLine();

        Invoice invoice1 = new Invoice(customerName1); // creates invoice with customer name

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter the title of book " + i + ": "); // gets title from user and assigns to variable
            String title = scnr.nextLine(); 

            System.out.print("Enter the price of the book " + i + ": "); // gets price from user and assigns it to a variable
            double price = scnr.nextDouble();

            System.out.print("Enter the weight of book " + i + ": "); // gets weight from user and assigns to variable
            double weight = scnr.nextDouble();
            
            scnr.nextLine(); // Consume the newline character (kept getting errors)

            invoice1.addBook(title, price, weight); // Add book to the first invoice
        }

        System.out.print("Enter 2nd Customer Name:"); // gets customer name from user and assigns to variable
        String customerName2 = scnr.nextLine();

        Invoice invoice2 = new Invoice(customerName2); // creates invoice with 2nd customer name

        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter the title of book " + i + ": "); // gets title from user and assigns to variable
            String title = scnr.nextLine();

            System.out.print("Enter the price of the book " + i + ": "); // gets price from user and assigns it to a variable
            double price = scnr.nextDouble();

            System.out.print("Enter the weight of book " + i + ": "); // gets weight from user and assigns to variable
            double weight = scnr.nextDouble();
            
            scnr.nextLine(); // Consume the newline character

            invoice2.addBook(title, price, weight); // Add book to the second invoice
        }
        
        System.out.print("Enter the percentage of discount for book 1 in each invoice: ");
		int percentDiscount1 = scnr.nextInt();
		double discount1 = percentDiscount1 / 100; // convert discount before passing to method
		
		invoice1.applyDiscount(1, discount1); //Apply 10% discount to book #1 on both invoices.
		invoice2.applyDiscount(1, discount1); //Apply 10% discount to book #1 on both invoices.
		
		System.out.print("Enter the percentage of discount for book 2 in each invoice: ");
		int percentDiscount2 = scnr.nextInt();
		double discount2 = percentDiscount2/ 100; // convert discount before passing to method
		
		
		invoice1.applyDiscount(2, discount2); //Apply 20% discount to book #2 on both invoices.
		invoice2.applyDiscount(2, discount2); 

		System.out.print("Enter the dollar amount you want removed from book 3: ");
		int amountDiscounted = scnr.nextInt();
		double priceAdjustment = amountDiscounted;
		invoice1.adjustPrice(3, priceAdjustment); //Adjust the price of book #3 in the second invoice by adding $2.
			
		System.out.println(invoice1.toString()); //prints both invoices in a nicely formatted output (use tax rate of 4.5%).
		System.out.println(invoice2.toString());
		
		scnr.close();
        
	}

}

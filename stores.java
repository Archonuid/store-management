package storemgmtsystem;

import java.util.Scanner;

public class Store {



	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);

		// Displaying menu
		System.out.println(
			"********************Welcome to the Store!********************");
		System.out.println(
			"				 Select From The Following Options:			 ");
		System.out.println(
			"**********************************************************************");

		// Creating object of book class
		Products ob = new Products();
		// Creating object of students class
		Buyers obBuyer = new Buyers();

		int choice;
		int searchChoice;

		// Creating menu
		// using do-while loop
		do {

			ob.dispMenu();
			choice = input.nextInt();

			// Switch case
			switch (choice) {

				// Case
			case 1:
				Product p = new Product();
				ob.addProduct(p);
				break;

				// Case
			case 2:
				ob.upgradeProductQty();
				break;

			// Case
			case 3:

				System.out.println(
					" press 1 to Search with Product Serial No.");
				System.out.println(
					" Press 2 to Search with Product's Seller Name.");
				searchChoice = input.nextInt();

				// Nested switch
				switch (searchChoice) {

					// Case
				case 1:
					ob.searchBySno();
					break;

					// Case
				case 2:
					ob.searchBySellerName();
				}
				break;

				// Case
			case 4:
				ob.showAllProducts();
				break;

				// Case
			case 5:
				Buyers s = new Buyer();
				obBuyer.addBuyer(b);
				break;

				// Case
			case 6:
				obBuyer.showAllBuyers();
				break;

				// Case
			case 7:
				obBuyer.checkOutProduct(ob);
				break;

				// Case
			case 8:
				obBuyer.checkInProduct(ob);
				break;

				
			default:

				// Print statement
				System.out.println("ENTER BETWEEN 0 TO 8.");
			}

		}

		// Checking condition at last where we are
		// checking case entered value is not zero
		while (choice != 0);
	}

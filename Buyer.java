package storemgmtsystem;

import java.util.Scanner;

public class Buyer {



	// Class member variables
	String BuyerName;
	public String regNum;

	Product boughtProducts[] = new Product[3];
	public int ProductsCount = 0;


	Scanner input = new Scanner(System.in);

	// Constructor
	public Buyer()
	{
		// Print statement
		System.out.println("Enter Buyer Name:");

		// This keywords refers to current instance
		this.buyerName = input.nextLine();

		// Print statement
		System.out.println("Enter Registration Number:");
		this.regNum = input.nextLine();
	}
}

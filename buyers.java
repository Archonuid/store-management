package storemgmtsystem;

import java.util.Scanner;

public class Buyers {





	// Creating objects of Scanner and students class
	Scanner input = new Scanner(System.in);
	Buyer theBuyers[] = new Buyer[50];

	public static int count = 0;

	// Method 1
	public void addBuyer(Buyer b)
	{
		for (int i = 0; i < count; i++) {

			if (b.regNum.equalsIgnoreCase(
					theBuyers[i].regNum)) {

				// Print statement
				System.out.println(
					"Buyer of Reg Num " + b.regNum
					+ " is Already Registered.");

				return;
			}
		}

		if (count <= 50) {
			theBuyers[count] = b;
			count++;
		}
	}

	// Method 2
	// Displaying all students
	public void showAllBuyers()
	{
		// Printing student name and
		// corresponding registered number
		System.out.println("Buyer Name\t\tReg Number");
		for (int i = 0; i < count; i++) {

			System.out.println(theBuyers[i].buyerName
							+ "\t\t"
							+ theBuyers[i].regNum);
		}
	}

	// Method 3
	public int isBuyer()
	{
		// Display message only
		System.out.println("Enter Reg Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++) {

			if (theBuyers[i].regNum.equalsIgnoreCase(
					regNum)) {
				return i;
			}
		}

		// Print statements
		System.out.println("Buyer is not Registered.");
		System.out.println("Get Registered First.");

		return -1;
	}

	// Method 4

	public void checkOutProduct(Products product)
	{
		int buyerIndex = this.isBuyer();

		if (buyerIndex != -1) {
			System.out.println("checking out");

			product.showAllProducts();
			Product p = product.checkOutProduct();

			System.out.println("checking out");
			if (p != null) {

				if (theBuyers[buyerIndex].productsCount
					<= 3) {

					System.out.println("adding product");
					theBuyers[buyerIndex].borrowedProducts
						[theBuyers[buyerIndex]
							.productsCount]
						= p;
					theBuyers[buyerIndex].productsCount++;

					return;
				}
				else {

					System.out.println(
						"Buyer Can not Borrow more than 3 Products.");
					return;
				}
			}
			System.out.println("Product is not Available.");
		}
	}

	// Method 5

	public void checkInProduct(Products product)
	{
		int buyerIndex = this.isBuyer();
		if (buyerIndex != -1) {

			// Printing credentials corresponding to student
			System.out.println(
				"S.No\t\t\tProduct Name\t\t\tSeller Name");

			Buyer b = theBuyers[buyerIndex];

			for (int i = 0; i < b.productsCount; i++) {

				System.out.println(
					b.boughtProducts[i].sNo + "\t\t\t"
					+ b.boughtProducts[i].productName + "\t\t\t"
					+ b.boughtProducts[i].sellerName);
			}

			// Display message only
			System.out.println(
				"Enter Serial Number of Product to be Checked In:");

			int sNo = input.nextInt();

			for (int i = 0; i < b.productsCount; i++) {
				if (sNo == b.boughtProducts[i].sNo) {
					product.checkInProduct(b.boughtProducts[i]);
					b.boughtProducts[i] = null;
					return;
				}
			}

			System.out.println("Product of Serial No " + sNo
							+ "not Found");
		}
	}
}

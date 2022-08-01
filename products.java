package storemgmtsystem;

import java.util.Scanner;

public class Products {




	// Class data members
	Product theProducts[] = new Product[50];
	public static int count;

	Scanner input = new Scanner(System.in);

	
	public int compareProductObjects(Product p1, Product p2)
	{

		
		if (p1.productName.equalsIgnoreCase(p2.productName)) {

			
			System.out.println(
				"Product of this Name Already Exists.");
			return 0;
		}

		
		if (p1.sNo == p2.sNo) {

			
			System.out.println(
				"Product Already Exists.");

			return 0;
		}
		return 1;
	}

	// Method 2
	// To add product
	public void addProduct(Product p)
	{

		for (int i = 0; i < count; i++) {

			if (this.compareProductObjects(p, this.theProducts[i])
				== 0)
				return;
		}

		if (count < 50) {

			theProducts[count] = p;
			count++;
		}
		else {

			System.out.println(
				"No more Products.");
		}
	}

	// Method 3
	// To search book by serial number
	public void searchBySno()
	{

		// Display message
		System.out.println(
			"\t\t\t\tSEARCH BY SERIAL NUMBER\n");

		// Class data members
		int sNo;
		System.out.println("Enter Serial No of Product:");
		sNo = input.nextInt();

		int flag = 0;
		System.out.println(
			"S.No\t\tName\t\tseller\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			if (sNo == theProducts[i].sNo) {
				System.out.println(
					theProducts[i].sNo + "\t\t"
					+ theProducts[i].productName + "\t\t"
					+ theProducts[i].sellerName + "\t\t"
					+ theProducts[i].productQtyCopy + "\t\t"
					+ theProducts[i].productQty);
				flag++;
				return;
			}
		}
		if (flag == 0)
			System.out.println("No Product for Serial No "
							+ sNo + " Found.");
	}

	
	public void searchBySellerName()
	{

		// Display message
		System.out.println(
			"\t\t\t\tSEARCH BY SELLER'S NAME");

		input.nextLine();

		System.out.println("Enter Seller Name:");
		String sellerName = input.nextLine();

		int flag = 0;

		System.out.println(
			"S.No\t\tName\t\tSeller\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {

	
			if (sellerName.equalsIgnoreCase(
					theProducts[i].sellerName)) {

				
				System.out.println(
					theProducts[i].sNo + "\t\t"
					+ theProducts[i].productName + "\t\t"
					+ theProducts[i].sellerName + "\t\t"
					+ theProducts[i].productQtyCopy + "\t\t"
					+ theProducts[i].productQty);
				flag++;
			}
		}

		if (flag == 0)
			System.out.println("No Product of " + sellerName
							+ " Found.");
	}

	public void showAllProducts()
	{

		System.out.println("\t\t\t\tSHOWING ALL PRODUCTS\n");
		System.out.println(
			"S.No\t\tName\t\tSeller\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {

			System.out.println(
				theProducts[i].sNo + "\t\t"
				+ theProducts[i].productName + "\t\t"
				+ theProducts[i].sellerName + "\t\t"
				+ theProducts[i].productQtyCopy + "\t\t"
				+ theProducts[i].productQty);
		}
	}


	public void upgradeProductQty()
	{

		System.out.println(
			"\t\t\t\tUPGRADE QUANTITY OF A PRODUCT\n");
		System.out.println("Enter Serial No of Product");

		int sNo = input.nextInt();

		for (int i = 0; i < count; i++) {

			if (sNo == theProducts[i].sNo) {

				// Display message
				System.out.println(
					"Enter No of Products to be Added:");

				int addingQty = input.nextInt();
				theProducts[i].productQty += addingQty;
				theProducts[i].productQtyCopy += addingQty;

				return;
			}
		}
	}

	// Method 7
	// To create menu
	public void dispMenu()
	{

		// Displaying menu
		System.out.println(
			"----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 1 to Add new Product.");
		System.out.println("Press 0 to Exit Application.");
		System.out.println(
			"Press 2 to Upgrade Quantity of a Product.");
		System.out.println("Press 3 to Search a Product.");
		System.out.println("Press 4 to Show All Products.");
		System.out.println("Press 5 to Register buyer.");
		System.out.println(
			"Press 6 to Show All Registered Buyers.");
		System.out.println("Press 7 to Check Out Product. ");
		System.out.println("Press 8 to Check In Product");
		System.out.println(
			"-------------------------------------------------------------------------------------------------------");
	}

	// Method 8
	// To search 
	public int isAvailable(int sNo)
	{

		for (int i = 0; i < count; i++) {
			if (sNo == theProducts[i].sNo) {
				if (theProducts[i].ProductQtyCopy > 0) {

					System.out.println(
						"Product is Available.");
					return i;
				}
				System.out.println("Product is Unavailable");
				return -1;
			}
		}

		System.out.println("No Product of Serial Number "
						+ " Available in Library.");
		return -1;
	}


	public Product checkOutProduct()
	{

		System.out.println(
			"Enter Serial No of Product to be Checked Out.");
		int sNo = input.nextInt();

		int ProductIndex = isAvailable(sNo);

		if (ProductIndex != -1) {
			theProducts[ProductIndex].ProductQtyCopy--;
			return theProducts[ProductIndex];
		}
		return null;
	}

	
	public void checkInProduct(Product p)
	{
		for (int i = 0; i < count; i++) {
			if (p.equals(theProducts[i])) {
				theProducts[i].ProductQtyCopy++;
				return;
			}
		}
	}
}

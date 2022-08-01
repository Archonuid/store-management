package storemgmtsystem;

import java.util.Scanner;

public class Product {


		// Class data members
		public int sNo;
		public String productName;
		public String sellerName;
		public int productQty;
		public int productQtyCopy;

		// Creating object of Scanner class to
		// read input from users
		Scanner input = new Scanner(System.in);

		// Method
		// To add product details
		public Product()
		{
			// Display message for taking input later
			// taking input via
			// nextInt() and nextLine() standard methods
			System.out.println("Enter Serial No of Product:");
			this.sNo = input.nextInt();
			input.nextLine();

			System.out.println("Enter Product Name:");
			this.productName = input.nextLine();

			System.out.println("Enter Seller Name:");
			this.sellerName = input.nextLine();

			System.out.println("Enter Quantity of Product:");
			this.productQty = input.nextInt();
			productQtyCopy = this.productQty;
		}
	}

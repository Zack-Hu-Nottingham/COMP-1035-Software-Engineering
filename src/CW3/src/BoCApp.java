import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BoCApp {
	public static ArrayList<BoCTransaction> UserTransactions;
	public static ArrayList<BoCCategory> UserCategories;

	public static void main(String[] args) {
		UserCategories = new ArrayList<BoCCategory>();
		UserTransactions = new ArrayList<BoCTransaction>();

		// SETUP EXAMPLE DATA //
		UserCategories.add(new BoCCategory("Unknown"));
		BoCCategory BillsCategory = new BoCCategory("Bills");
		// Modified: Ziyi Wang (scyzw10)
		// Last modified: 2021/4/27 20:08
		// Reason: The type of the parameter of the  .setCategoryBudget() should be Float
		// original: BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		BillsCategory.setCategoryBudget(120.00F);	// modified Ziyi Wang (2021/4/27 20:08)
		UserCategories.add(BillsCategory);
		BoCCategory Groceries = new BoCCategory("Groceries");
		// original: Groceries.setCategoryBudget(new BigDecimal("75.00"));
		Groceries.setCategoryBudget(75.00F);	// modified Ziyi Wang (2021/4/27 20:08)
		UserCategories.add(Groceries);
		BoCCategory SocialSpending = new BoCCategory("Social");
		// original: SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
		SocialSpending.setCategoryBudget(100.00F);	// modified Ziyi Wang (2021/4/27 20:08)
		UserCategories.add(SocialSpending);

		UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
		UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
		UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
		UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
		UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));

		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			BoCCategory temp2 = UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			UserCategories.set(utCat, temp2);
		}

		// MAIN FUNCTION LOOP

		//CategoryOverview();
		System.out.println(
				"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("T")) {
					ListTransactions();
				} else if (s.equals("O")) {
					CategoryOverview();
				} else if (s.equals("C")) {
					ChangeTransactionCategory(in);
				} else if (s.equals("N")) {
					AddCategory(in);
				} else if (s.equals("A")) {
					AddTransaction(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else { // Author: Leshan Tan (sqylt2)
					try{ // Last Modified: 2021/4/27 13:54
						ListTransactionsForCategory(Integer.parseInt(s)); // Reason: Previous code did not handle this condition correctly
					}catch (NumberFormatException exc){
						System.out.println("Command not recognised");
					}
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}

			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		}
		in.close();
	}
	// Author: Lin Chen (biylc2)
	// Last Modified : 2021/04/28 0:33
	// Reason: The format of the output is not matched to the expected ones.
	public static void ListTransactions() {
		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			System.out.println((x + 1) + ") " + temp.transactionName()+" ("+UserCategories.get(temp.transactionCategory()).CategoryName()+") - ¥"+temp.transactionValue());
		}
	}

	public static void CategoryOverview() {
		for (int x = 0; x < UserCategories.size(); x++) {
			BoCCategory temp = UserCategories.get(x);
			System.out.println((x + 1) + ") " + temp.toString());
		}

	}

	// Author: Leshan Tan (sqylt2)
	// Last Modified: 2021/4/27 20:27
	// Reason: add an if to test if the input category already in the list
	public static void ListTransactionsForCategory(int chosenCategory) {
		// the category number should be already in the list, counting from 0 to UserCategories.size() - 1
		if (chosenCategory < 0 || chosenCategory > UserCategories.size() - 1) // the category should be already in the list, counting from 0 to UserCategories.size() - 1
		{
			System.out.println("Cannot find transactions with category " + chosenCategory); // print corresponding error messages
		}
		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			if (temp.transactionCategory() == chosenCategory) {
				System.out.println((x + 1) + ") " + temp.toString());
			}
		}
	}

	private static void AddTransaction(Scanner in) {
		System.out.println("What is the title of the transaction?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		System.out.println("What is the value of the transaction?");
		BigDecimal tvalue = new BigDecimal(in.nextLine());
		//UserTransactions.add(new BoCTransaction(title, tvalue, 0));
		System.out.println("[Transaction added]");
	}

	//Author: Yicun Duan (scyyd3)
	//Last Modified: 2021/4/28 00:13
	//Reason: The output of this function is not the same as the expected output.
	//		  It can't handle invalid input and it can't check the boundary yet.
	//		  Unable to calculate the remaining amount of old category after changing category is also a problem.
	private static void ChangeTransactionCategory(Scanner in) {
		//read the input from next line
		in.nextLine();
		//set the default transaction id (actual: tID - 1) and category id (actual: category id -1)
		int tID = 0;
		int newCat = 0;
		//set the "runAgain" to control the loop
		boolean runAgain = true;

		while (runAgain) {
			//list transactions
			ListTransactions();
			System.out.println("Which transaction ID?");
			try{
				//parse the input as integer
				tID = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e){
				//if the input can be parsed as an integer, print a warning
				System.out.println("Invalid input. Please input a valid integer.");
				continue;
			}

			if (tID <= 0 || tID > UserTransactions.size()) {
				//if the input id is out of boundary, print a warning
				System.out.println("Transaction doesn't exist. Please input again.");
				continue;
			}

			//end the loop
			runAgain = false;
		}

		//print out the selected transaction
		System.out.println("\t- " + UserTransactions.get(tID - 1).toString());

		//reset the loop controller
		runAgain = true;

		while (runAgain) {
			//print out the categories
			CategoryOverview();
			System.out.println("Which category will it move to?");
			try{
				newCat = Integer.parseInt(in.nextLine());
			}catch (NumberFormatException e){
				System.out.println("Invalid input. Please input a valid integer.");
				continue;
			}

			if (newCat <= 0 || newCat > UserCategories.size()) {
				System.out.println("Category doesn't exist. Please input again.");
				continue;
			}
			runAgain = false;
		}

		//find the actual new category id
		int newCatNum = newCat - 1;

		//get the selected transaction
		BoCTransaction curTrans = UserTransactions.get(tID - 1);
		//find the actual old category id
		int oldCatNum = curTrans.transactionCategory();
		//reset the category of selected transaction
		curTrans.setTransactionCategory(newCatNum);
		//put the changed transaction back to array
		UserTransactions.set(tID - 1, curTrans);

		//get the new category
		BoCCategory newCategory = UserCategories.get(newCatNum);
		//add expense to new category
		newCategory.addExpense(curTrans.transactionValue());
		//put the changed category back to array
		UserCategories.set(newCatNum, newCategory);

		//get the old category
		BoCCategory oldCategory = UserCategories.get(oldCatNum);
		//remove expense from old category
		oldCategory.removeExpense(curTrans.transactionValue());
		//put the changed old category back to array
		UserCategories.set(oldCatNum, oldCategory);

		//print out the new category
		System.out.println(newCategory.toString());
		//print out the old category
		System.out.println(oldCategory.toString());
	}

	// Modified: Yingxiao Huo (scyyh9)
	// Last modified: 2021/4/27 21:31
	// Reason:  Name can not longer than 15 characters.
	//  		value should be positive number.
	// 			The type of the parameter of the temp.setCategoryBudget() should be Float.
	private static void AddCategory(Scanner in) {
		System.out.println("What is the title of the category?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();

		//if user enter a string longer than 15 characters, program will take substring of the string which is 15 characters long.
		if (title.length() > 15) {
			title = title.substring(0, 15);
		}
		//if user enter a name which is already exist, program throws a IllegalArgumentException, catch the exception, and return to the main menu.
		try {
			if(UserCategories.size() != 0){
				for (int i = 0; i < UserCategories.size(); i++) {
					String cateName = UserCategories.get(i).CategoryName();
					if (cateName.equals(title)) {
						throw new IllegalArgumentException("This category is already exist.");
					}
				}
			}
		} catch (IllegalArgumentException ex1) {
			System.out.print("This category is already exist.");
			return;
		}
		System.out.println("What is the budget for this category?");

		//if user enter a string which is not digital, program throw a NumberFormatException and catch it, return to the main menu.
		//if user enter a negative number, throw and catch an IllegalArgumentException, and return to the main menu.
		try {
			try {
				// original: BigDecimal cbudget = new BigDecimal(in.nextLine());
				float cbudget = Float.parseFloat(in.nextLine());    // change the type of cbudget (Ziyi Wang 2021/4/27 20:09)
				if (cbudget < 0) {
					throw new IllegalArgumentException("Budget only can be positive number.");
				}
				BoCCategory temp = new BoCCategory(title);
				temp.setCategoryBudget(cbudget);
				UserCategories.add(temp);
			} catch (NumberFormatException ex2) {
				System.out.print("Budget only can be positive number.");
				return;
			}
		} catch (IllegalArgumentException ex3) {
			System.out.print("Budget only can be positive number.");
			return;
		}

		//valid input, print the new category list.
		System.out.println("[Category added]");
		CategoryOverview();
	}

}

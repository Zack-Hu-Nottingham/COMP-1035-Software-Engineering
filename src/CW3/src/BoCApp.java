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
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		UserCategories.add(BillsCategory);
		BoCCategory Groceries = new BoCCategory("Groceries");
		Groceries.setCategoryBudget(new BigDecimal("75.00"));
		UserCategories.add(Groceries);
		BoCCategory SocialSpending = new BoCCategory("Social");
		SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
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
				} else if (Integer.parseInt(s) != -1) {
					ListTransactionsForCategory((int) Integer.parseInt(s));
				} else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}

			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		}
		in.close();
	}

	public static void ListTransactions() {
		for (int x = 0; x < UserTransactions.size(); x++) {
			BoCTransaction temp = UserTransactions.get(x);
			System.out.println((x + 1) + ") " + temp.toString());
		}
	}

	public static void CategoryOverview() {
		for (int x = 0; x < UserCategories.size(); x++) {
			BoCCategory temp = UserCategories.get(x);
			System.out.println((x + 1) + ") " + temp.toString());
		}

	}

	public static void ListTransactionsForCategory(int chosenCategory) {
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

	private static void ChangeTransactionCategory(Scanner in) {
		in.nextLine();
		int tID = 0;
		int newCat = 0;
		boolean runAgain = true;

		while (runAgain) {
			ListTransactions();
			System.out.println("Which transaction ID?");
			try{
				tID = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e){
				System.out.println("Invalid input. Please input a valid integer.");
				continue;
			}

			if (tID <= 0 || tID > UserTransactions.size()) {
				System.out.println("Transaction doesn't exist. Please input again.");
				continue;
			}

			runAgain = false;
		}

		System.out.println("\t- " + UserTransactions.get(tID - 1).toString());

		runAgain = true;

		while (runAgain) {
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

		int newCatNum = newCat - 1;

		BoCTransaction curTrans = UserTransactions.get(tID - 1);
		int oldCatNum = curTrans.transactionCategory();
		curTrans.setTransactionCategory(newCatNum);
		UserTransactions.set(tID - 1, curTrans);

		BoCCategory newCategory = UserCategories.get(newCatNum);
		newCategory.addExpense(curTrans.transactionValue());
		UserCategories.set(newCatNum, newCategory);

		BoCCategory oldCategory = UserCategories.get(oldCatNum);
		oldCategory.removeExpense(curTrans.transactionValue());
		UserCategories.set(oldCatNum, oldCategory);

		System.out.println(newCategory.toString());
		System.out.println(oldCategory.toString());
	}

	private static void AddCategory(Scanner in) {
		System.out.println("What is the title of the category?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		System.out.println("What is the budget for this category?");
		BigDecimal cbudget = new BigDecimal(in.nextLine());
		BoCCategory temp = new BoCCategory(title);
		temp.setCategoryBudget(cbudget);
		UserCategories.add(temp);
		System.out.println("[Category added]");
		CategoryOverview();
	}

}

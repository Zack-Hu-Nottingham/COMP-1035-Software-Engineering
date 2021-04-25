import java.math.BigDecimal;

public class BoCCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;

	public BoCCategory() {
		CategoryName = "New Category";
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	public BoCCategory(String newTitle) {
		CategoryName = newTitle;
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	//author: Yingxiao Huo (scyyh9)
	//Last modified time: 2021/4/24 23:25
	//Reason: Name can not longer than 15 characters, and name can not be null
	public String CategoryName() throws IllegalArgumentException{
		if (CategoryName == null){
			throw new IllegalArgumentException("Name is not set.");
 		}
		else if (CategoryName.length() > 15){
			throw new IllegalArgumentException("Category name can not longer than 15 characters.");
		}
		else {
			return CategoryName;
		}
	}

	public BigDecimal CategoryBudget() {
		return CategoryBudget;
	}

	public BigDecimal CategorySpend() {
		return CategorySpend;
	}

	public void setCategoryName(String newName) {
		CategoryName = newName;
	}

	public void setCategoryBudget(BigDecimal newValue) {
		// 1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
	}

	//Modifier: LinCHEN(biylc2)
	//Last Modify:2021/04/25
	//Reason: Cause when the valueToAdd is negative or null, it cannot be set. the previous function cannot catch the exception and print useful error message.

	public void addExpense(BigDecimal valueToAdd) throws NullPointerException,IllegalArgumentException {
		if(valueToAdd == null){
			throw new NullPointerException("Illegal input");
		}

		if (valueToAdd.compareTo(BigDecimal.ZERO)==-1) {
			throw new IllegalArgumentException("Illegal input");
		}else {
			CategorySpend = CategorySpend.add(valueToAdd);
		}

	}

	public void removeExpense(BigDecimal valueToRemove) {
		CategorySpend = CategorySpend.subtract(valueToRemove);
	}

	public void resetBudgetSpend() {
		CategorySpend = new BigDecimal("0.00");
	}

	public BigDecimal getRemainingBudget() {
		BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
		return remainingBudget;
	}

	//Modifier: LinCHEN(biylc2)
	//Last Modify:2021/04/24
	//Reason: Cause when the remaining budget is negative, the previous function will have a wrong output

	@Override
	public String toString() {
		if (getRemainingBudget().compareTo(new BigDecimal("0.00")) > -1)
			return "[" + CategoryName + "]" + "(Budget: ¥" + CategoryBudget.toPlainString() + ") - ¥" + CategorySpend.toPlainString()
					+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
		else
			return "[" + CategoryName + "]" + "(Budget: ¥" + CategoryBudget.toPlainString() + ") - ¥" + CategorySpend.toPlainString()
					+ " (¥" + getRemainingBudget().abs().toPlainString() + " Overspent)";
	}

}

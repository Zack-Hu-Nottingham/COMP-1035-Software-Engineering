import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class BoCCategory {
	private String CategoryName;
	private BigDecimal CategoryBudget;
	private BigDecimal CategorySpend;

	public BoCCategory() {
		CategoryName = "New Category";
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
	}

	// Author: Ziyi Wang (scyzw10)
	// Last modified: 2021/4/25
	// Reason: The length of the Category Name should be no more than 15 characters
	// 		   Add exception to the source code
	public BoCCategory(String newTitle) throws InvalidParameterException{
		CategoryBudget = new BigDecimal("0.00");
		CategorySpend = new BigDecimal("0.00");
		//if the length of the newTitle > 15 , then throw exception
		if (newTitle.length() > 15){
			throw new InvalidParameterException("Category Name at most 15 characters.");
		}else{
			CategoryName = newTitle;
		}
	}

	// Author: Yingxiao Huo (scyyh9)
	// Last modified time: 2021/4/24 23:25
	// Reason: Name can not longer than 15 characters, and name can not be null
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

	public void setCategoryName(String newName) throws IllegalArgumentException{
		if (newName == null || newName.isBlank()){
			throw new IllegalArgumentException("Name can not be null");
		}
		else if (newName.length() > 15){
			CategoryName = newName.substring(0,15);
		}
		else {
			CategoryName = newName;
		}
	}

	// Author: Ziyi Wang (scyzw10)
	// Last modified: 2021/4/25 11:00
	// Reason: The type of the parameter should be Float

	public void setCategoryBudget(BigDecimal newValue) {
//		BigDecimal newV = new BigDecimal(newValue);		//convert the Float type to BigDecimal
		// 1 means bigger, -1 means smaller, 0 means same
		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
			CategoryBudget = newValue;
		}
	}

	// Modifier: LinCHEN (biylc2)
	// Last Modify:2021/04/25 11:20
	// Reason: Cause when the valueToAdd is negative or null, it cannot be set. the previous function cannot catch the exception and print useful error message.

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

	// Author: Ziyi Wang (scyzw10)
	// Last modified: 2021/4/25 11:19
	// Reason: Both value of valueToRemove and the CategorySpend after remove could not less than zero
	// 		   Add exception to the source code
	public void removeExpense(BigDecimal valueToRemove)throws InvalidParameterException {
		//if valueToRemove < 0, then comp = -1
		int comp1 = valueToRemove.compareTo(new BigDecimal(0));
		if (comp1 == -1){
			throw new InvalidParameterException("The valueToRemove must be >= 0");
		}else{
			CategorySpend = CategorySpend.subtract(valueToRemove);
		}
		//if result(the value of CategorySpend after remove) < 0, then comp = -1
		int comp2 = CategorySpend.compareTo(new BigDecimal(0));
		if (comp2 == -1) {
			throw new InvalidParameterException("The CategorySpend is must be >= 0");
		}
	}

	public void resetBudgetSpend() {
		CategorySpend = new BigDecimal("0.00");
	}

	public BigDecimal getRemainingBudget() {
		BigDecimal remainingBudget = CategoryBudget.subtract(CategorySpend);
		return remainingBudget;
	}

	// Modifier: LinCHEN (biylc2)
	// Last Modify:2021/04/24
	// Reason: Cause when the remaining budget is negative, the previous function will have a wrong output

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

import java.math.BigDecimal;
import java.util.Date;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;

	public BoCTransaction() {
		transactionName = null;
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = null;
	}

	// Author: Zixiang Hu (20215538)
	// Last modified: 4/25 19:01
	// Reason to change:
	public BoCTransaction(String tName, BigDecimal tValue, int tCat) throws IllegalArgumentException{
		if (tName == null) {
			throw new IllegalArgumentException("Transaction name should not be null.");
		}
		if (tName.length() > 25) {
			throw new IllegalArgumentException("Transaction budget should greater than zero.");
		}
		if (tCat < 0) {
			throw new IllegalArgumentException("Transaction category should not be minus.");
		}
		if (tValue.compareTo(new BigDecimal(0)) < 1) {
			throw new IllegalArgumentException("Transaction budget should greater than zero.");
		}

		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}

	public String transactionName() {
		return transactionName;
	}

	public BigDecimal transactionValue() {
		return transactionValue;
	}

	public int transactionCategory() {
		return transactionCategory;
	}

	public Date transactionTime() {
		return transactionTime;
	}

	public void setTransactionName(String tName) {
		if (tName != null) {
			transactionName = tName;
		}
	}

	public void setTransactionValue(BigDecimal tValue) {
		if (tValue.compareTo(new BigDecimal("0.00")) == 1) {
			// 1 means bigger, -1 means smaller, 0 means same
			transactionValue = tValue;
		}
	}

	public void setTransactionCategory(int tCat) {
		if (tCat > 0) {
			transactionCategory = tCat;
		}
	}

	public void setTransactionTime(Date tTime) {
		if (tTime != null) {
			transactionTime = tTime;
		}
	}

	@Override
	public String toString() {
		return transactionName + " - ¥" + transactionValue.toString();
	}

}

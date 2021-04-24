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

	public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}

	public String transactionName() throws IllegalArgumentException{
		if (transactionName == null){
			throw new IllegalArgumentException("name is not set.");
		}
		else{
			return transactionName;
		}
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

	public void setTransactionName(String tName) throws IllegalArgumentException, UnsupportedOperationException{
		if (tName == null || tName.isBlank()) {
			throw new IllegalArgumentException("The transactionName is invalid.");
		}

		if (transactionName != null) {
			throw new UnsupportedOperationException("Transaction name cannot be repeatedly set.");
		}

		if (tName.length() > 25) {
			tName.substring(0, 25);
		}

		transactionName = tName;
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
	public String toString() throws IllegalArgumentException{
		if (transactionValue == null){
			return transactionName + " - ¥" + "Unknownvalue".toString();
		}
		if (Integer.parseInt(String.valueOf(transactionValue)) < 0){
			throw new IllegalArgumentException("Value can not be negative number");
		}
		return transactionName + " - ¥" + transactionValue.toString();
	}

	//Author :LinCHEN(biylc2)
	//Last Modify:2021/04/24 14:37

	public boolean isComplete(){

		if (transactionName != "[Pending Transaction]"&& transactionName != null){
			if (transactionValue!= null){
				return true;
			}
		}
		return false;

	}

}

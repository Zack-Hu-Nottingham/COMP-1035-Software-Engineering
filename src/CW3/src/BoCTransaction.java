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

	//author: Yingxiao Huo
	//Last modify: 22021/4/24
	//Reason: when transaction name is null or is longer than 25 characters, the program should report an error.
	public String transactionName() throws IllegalArgumentException{
		if (transactionName == null){
			throw new IllegalArgumentException("name is not set.");
		}
		else if (transactionName.length() > 25){
			throw new IllegalArgumentException("Name can not longer than 25 characters.");
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

	//Author: LinCHEN(biylc2)
	//Last Modify:2021/04/25
	//Reason: The previous function cannot handle the situation that when the value is non-positive and does not throw an expection as expected
	public void setTransactionValue(BigDecimal tValue) throws UnsupportedOperationException,NullPointerException,IllegalArgumentException,UnsupportedOperationException {
//		if(tValue== null){
//			throw new NullPointerException("The value cannot be null.");
//		}else if(tValue.compareTo(BigDecimal.ZERO) <=0){
//			throw new IllegalArgumentException("The value should be a positive number, the set fails");
//		}else if(isComplete()==1 || isComplete()==3) {
//			throw new UnsupportedOperationException("The value cannot be set twice");
//		}else{
//			transactionValue = tValue;
//			if(transactionValue!=tValue){
//				throw new UnsupportedOperationException( "The set value is not the same as the expected one");
//			}
//		}



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

	//Yingxiao Huo (scyyh9)
	//Last modify: 2021/4/24
	//Reason: when transaction value is null, program should print Unknown value, and value can not be negative.
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
	//Reason: isComplete function is not
	public int isComplete(){

		if (transactionName != "[Pending Transaction]"&& transactionName != null){

			if (transactionValue!= null){
				return 1;
			}
			else{
				return 2;
			}
		}
		else {
			if (transactionValue!= null){
				return 3;
			}
			else{
				return 4;
			}
		}

	}

}

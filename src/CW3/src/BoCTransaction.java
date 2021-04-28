import java.math.BigDecimal;
import java.util.Date;

public class BoCTransaction {
	private String transactionName;
	private BigDecimal transactionValue;
	private int transactionCategory;
	private Date transactionTime;


	// Author: Leshan Tan (sqylt2)
	// Last modified: 4/26 9:05
	// Reason: The initial transactionName should be "Pending Transaction]" and transaction Date should be the current time.
	public BoCTransaction() {
		transactionName = "[Pending Transaction]";
		transactionValue = null;
		transactionCategory = 0;
		transactionTime = new Date();
	}


	// Author: Zixiang Hu (scyzh6)
	// Last modified: 4/25 19:01
	// Reason: If illegal value are entered it should throw exception to handle it.
	public BoCTransaction(String tName, BigDecimal tValue, int tCat) throws IllegalArgumentException{
		if (tName == null) {
			throw new IllegalArgumentException("Transaction name should not be null.");
		}
		if (tName.length() > 25) {
			throw new IllegalArgumentException("Transaction name should be limited to 25 characters.");
		}
		if (tCat < 0) {
			throw new IllegalArgumentException("Transaction category should not be minus.");
		}
		if(tValue==null){
			throw new IllegalArgumentException("Transaction budget should not be null.");
		}
		else if (tValue.compareTo(new BigDecimal(0)) < 1) {
			throw new IllegalArgumentException("Transaction budget should greater than zero.");
		}

		transactionName = tName;
		transactionValue = tValue;
		transactionCategory = tCat;
		transactionTime = new Date();
	}


	// Author: Yingxiao Huo
	// Last modify: 22021/4/24 18:44
	// Reason: When transaction name is null or is longer than 25 characters, the program should report an error.
	public String transactionName() throws IllegalArgumentException{
		//When name is not set, throw a IllegalArgumentException.
		if (transactionName == null){
			throw new IllegalArgumentException("name is not set.");
		}
		//Name can not longer than 25 characters, in setTransactionName, if user enter a String longer than 25 characters
		//the program will take the substring of the input string, so in this method, name should not longer than 25 characters.
		else if (transactionName.length() > 25){
			throw new IllegalArgumentException("Name can not longer than 25 characters.");
		}
		//normal case.
		else{
			return transactionName;
		}
	}

	// Author: Leshan Tan (sqylt2)
	// Last modify: 22021/4/29 2:45
	// Reason: transactionValue should be larger than zero, so if transactionValue <= 0, throw an exception
	public BigDecimal transactionValue() throws IllegalArgumentException{
		int flag = transactionValue.compareTo(new BigDecimal("0.00")); // get the result of value compared to 0
		if (flag == 0 || flag == -1){ // if transactionValue <= 0, throw exception
			throw new IllegalArgumentException("transactionValue can not be less than or equal to zero.");
		}
		return transactionValue;
	}


	public int transactionCategory() {
		return transactionCategory;
	}


	public Date transactionTime() {
		return transactionTime;
	}

	//Author: Yicun Duan (scyyd3)
	//Last Modified: 2021/4/28 00:48
	//Reason: The function can't check out the case where transaction name are set repeatedly.
	//		  It cannot validate input "tName" yet.
	//		  It cannot truncate string with length larger than 25 characters yet.
	public void setTransactionName(String tName) throws IllegalArgumentException, UnsupportedOperationException{
		//check whether transaction name is set as "[Pending Transaction]"
		if (!transactionName.equals("[Pending Transaction]")) {
			//if not, throw out an exception
			throw new UnsupportedOperationException("Transaction name cannot be repeatedly set.");
		}

		//test whether input "tName" is valid
		if (tName == null || tName.isBlank()) {
			throw new IllegalArgumentException("The transactionName is invalid.");
		}

		//truncate the string if necessary
		if (tName.length() > 25) {
			tName = tName.substring(0, 25);
		}

		//reset the transaction name
		transactionName = tName;
	}


	// Author: LinCHEN (biylc2)
	// Last Modify: 2021/04/25
	// Reason: The previous function cannot handle the situation that when the value is non-positive and does not throw an exception as expected.
	public void setTransactionValue(BigDecimal tValue) throws UnsupportedOperationException,NullPointerException,IllegalArgumentException,UnsupportedOperationException {
		// There are 3 exception cases : the input is null, the value is negative, if the set value can be seted twice
		if (tValue== null) {
			throw new NullPointerException("The value cannot be null.");
		} else if (tValue.compareTo(BigDecimal.ZERO) <=0){
			throw new IllegalArgumentException("The value should be a positive number, the set fails");
		} else if (isComplete()==1 || isComplete()==3) {
			// check whether the value can be set
			throw new UnsupportedOperationException("The value cannot be set twice");
		} else {
			transactionValue = tValue;
		}
	}


	// Author: Zixiang Hu (scyzh6)
	// Last modified: 4/25 19:01
	// Reason: If category input is less than or equal to zero, it should throw an exception to handle it.
	public void setTransactionCategory(int tCat) {
		if (tCat >= 0) {	// CategoryNumber could be equal to zero[Modified Ziyi Wang (2021/4/28 20:34)]
			transactionCategory = tCat;
		} else {
			throw new IllegalArgumentException("Transaction category should greater than zero.");
		}
	}



	// Author: Yingxiao Huo (scyyh9)
	// Last modify: 2021/4/24
	// Reason: when transaction value is null, program should print Unknown value, and value can not be negative.
	@Override
	public String toString() throws IllegalArgumentException{
		//When transaction value is not set, return unknown value.
		if (transactionValue == null){
			return transactionName + " - ¥" + "Unknownvalue";
		}
//		compare two bigDecimal can use .compareTo()
//		if (Integer.parseInt(String.valueOf(transactionValue)) < 0){
//			throw new IllegalArgumentException("Value can not be negative number");
//		}
		//transaction value can not be negative number.
		if (transactionValue.compareTo(new BigDecimal("0.00")) == -1) {
			throw new IllegalArgumentException("Value can not be negative number");
		}

		//return name value and date.
		return transactionName + " - ¥" + transactionValue.toString() + " Date: " + transactionTime;
	}


	// Author :LinCHEN(biylc2)
	// Last Modify:2021/04/24 14:37
	// Reason: isComplete function is not
	public int isComplete(){
		// There are two cases meaning that the name haven't been set.
		// The first case is using default constructor, in which case the name is "[Pending Transaction]" and it means it can be set
		// The second case is when the transactionName is null
		if (transactionName != "[Pending Transaction]"&& transactionName != null){
			//The null transactionValue means that the value haven't been set yet.
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

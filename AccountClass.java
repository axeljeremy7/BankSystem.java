

public class Account {
	private int accountNumber;
    private double accountBalance;
/**
 * Account Class: this contains functions such as: deposit and withdraw.
 * @param accountNumber: a int parameter to save account numbers.
 * @param accountBalance: a double parameter to save account balance.
 * Account Class has a constructor Account with two parameters(int accountNumber, double accountBalance)
 */
    public Account(int accountNumber, double accountBalance) {

        this.accountNumber = (accountNumber);
        this.accountBalance = (accountBalance);
    }
    /**
     * getAccountNumber is a method to return the attribute accountNumber
     * @return accountNumber
     */

    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * getAccountBalance is a method to return the attribute accountBalance
     * @return accountBalance
     */

    public double getAccountBalance() {
        return accountBalance;
    }
    /**
     * deposit is a method for the transaction of deposit
     * @param depositAmount: the amount which is going to be deposit
     * return accountBalance updated
     * 
     */

    public void deposit(double depositAmount) {

        accountBalance = accountBalance + depositAmount;

    }
    
    /**
     * withdraw is a method for the transaction of withdraw
     * @param withdrawAmount: the amount which is going to be withdraw
     * return accountBalance updated 
     */

    public void withdraw(double withdrawAmount) {
        accountBalance = accountBalance -(withdrawAmount) ;

    }

}

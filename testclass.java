package testpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import edu.wmich.cs1120.spring16.axellab1.Account;
/**
*Name: Axel Solano Illesca
*Assigment: Banking System
*Class: TestClass
*Description: The user can deposit, withdraw or transfer
*with the number of the account which is saved in a file.
*Date: Thursday January 28
* @author Axel Solano Illesca
*/


public class TestClass {

	public static void main(String[] args)  throws FileNotFoundException {
		String text = "input2.txt";
        File file = new File(text);
        Scanner reader = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (reader.hasNext()) {
            list.add(reader.nextLine());
        }
        reader.close();// get the info
        ArrayList<Integer> accNum = new ArrayList<Integer>();
        ArrayList<Double> acAm = new ArrayList<Double>();
        int m = list.size();
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            accNum.add(Integer.parseInt(result[0]));// account number
        }
       // System.out.println(accNum);
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            acAm.add(Double.parseDouble(result[1]));// account balance
        }
        //System.out.println(acAm);

        Scanner keyboard = new Scanner(System.in);
        printMenu();// print choices
        int n = getChoice(keyboard);
        boolean conti = true;
        while (conti) {
            if (n == 0) {
                System.exit(0);
                //keyboard.close();
                //conti = false;
            }
            if (n == 1) {
            	opctionOne();
                printMenu();
                n=getChoice(keyboard);
                if (n == 0) {
                	System.exit(0);
                } else {
                    conti = true;
                }
            }

            if (n == 2) {
            	optionTwo();
                printMenu();
                n=getChoice(keyboard);
                if (n == 0) {
                    System.exit(0);
                } else {
                    conti = true;
                }

            }

            if (n == 3) {
            	OptionThree();
                printMenu();
                n=getChoice(keyboard);
                if (n == 0) {
                	System.exit(0);
                } else {
                    conti = true;
                }

            }

        }
		

	}
	  /**
     * opctionOne is a method to make deposit in one account number
     * This method has no parameter
     * I read the file and then put the the information in two ArrayList
     * accNum: ArrayList of integers about account numbers
     * acAm: ArrayList of double about the balance in the account
     * Uno is an Account Object and is for the deposit
     * @throws FileNotFoundException
     * * Also update the file with a function
     */
    
    public static void opctionOne() throws FileNotFoundException{
		String text = "input2.txt";
        File file = new File(text);
        Scanner reader = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (reader.hasNext()) {
            list.add(reader.nextLine());
        }
        reader.close();
        ArrayList<Integer> accNum = new ArrayList<Integer>();
        ArrayList<Double> acAm = new ArrayList<Double>();
        int m = list.size();
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            accNum.add(Integer.parseInt(result[0]));// account number
        }
        
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            acAm.add(Double.parseDouble(result[1]));// account balance
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please input the account number-> ");
        int aconum = getAccountNumber(keyboard);
        double balance = 0;
        for (int i = 0; i < accNum.size(); i++) {
            if (accNum.get(i).equals(aconum)) {// compare to match
                balance = acAm.get(i);

            }
        }
        System.out.print("Please input the amount-> ");
        double amount = getAmount(keyboard);
        Account uno = new Account(aconum, balance);
        uno.deposit(amount);
        Account[] aco = new Account[1];
        aco[0] = uno;// pass the info to update
        updateAccountDatabase(aco);
		
	}
    
    /**
     * updateAccountDatabase is a function to write the updated information in the file
     * I read the file and then put the the information in two ArrayList
     * accNum: ArrayList of integers about account numbers
     * acAm: ArrayList of double about the balance in the account
     * Match the account number to set the updated balance.
     * @param account: Account array of objects and contains the information of the account number and balance.
     * Match the account number to set the updated balance.
     * @throws FileNotFoundException
     * PrintWriter is to write the updated information in the file
     */

    public static void updateAccountDatabase(Account[] account) throws FileNotFoundException {
        File file = new File("input2.txt");
        Scanner reader = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (reader.hasNext()) {
            list.add(reader.nextLine());
        }
        reader.close();
        ArrayList<Integer> accNum = new ArrayList<Integer>();
        ArrayList<Double> acAm = new ArrayList<Double>();
        int m = list.size();
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            accNum.add(Integer.parseInt(result[0]));
        }

        for (int j = 0; j < m; j++) {
			String[] result = list.get(j).split(" ");
			acAm.add(Double.parseDouble(result[1]));
		}

		for (int i = 0; i < accNum.size(); i++) {
			for (int j = 0; j < account.length; j++) {
				if (accNum.get(i).equals(account[j].getAccountNumber())) {// compare
																			// to
																			// match
					acAm.set(i, account[j].getAccountBalance());// setting in
																// the correct
																// index
				}

			}
		}

		PrintWriter write = new PrintWriter(file);// write the updated info in
													// the file
		for (int i = 0; i < accNum.size(); i++) {
			write.println(accNum.get(i) + " " + acAm.get(i));
		}
		write.close();
	}

	/**
	 * printMenu is a function to show the user the options such as: Deposit,
	 * Withdraw and Transfer return A String with the options:Deposit, Withdraw
	 * and Transfer
	 */
	
	public static void printMenu() {
        System.out.println("1.Deposit" + "\n" + "2.Withdraw" + "\n" + "3.Transfer" + "\n" + "0.Exit");
    }
	
	/**
	 * getChoice is a method to get the option of the user
	 * @param keyboard : is a scanner and is for reading the answer of the user
	 * @return n : an integer that is the option for Deposit, Withdraw or Transfer
	 */

    public static int getChoice(Scanner keyboard) {
        int n = keyboard.nextInt();
        return n;
    }
    
    /**
     * getAmount is a method to get the amount.
     * @param keyboard:  is a scanner and is for reading the answer of the user
     * @return n: a double that is the amount to update the account balance
     */

    public static double getAmount(Scanner keyboard) {
        double n = keyboard.nextDouble();
        return n;
    }
    
    /**
     * getAccountNumber is a method to get the account number of the user
     * @param keyboard:  is a scanner and is for reading the answer of the user
     * @return n: an integer that is the account number
     */

    public static int getAccountNumber(Scanner keyboard) {
        int n = keyboard.nextInt();
        return n;
    }
    /**
     * getTransferAccountNumbers is function to get the original account number and the transfer account number
     * @param keyboard:  is a scanner and is for reading the answer of the user
     * @return m: array of integers which are the account numbers
     */

    public static int[] getTransferAccountNumbers(Scanner keyboard) {
        System.out.print("Please input the account number-> ");
        int acoOriginal = getAccountNumber(keyboard);
        System.out.print("Please input the account number to transfer to-> ");
        int acoTransfer = getAccountNumber(keyboard);
        int[] m = new int[2];
        m[0] = acoOriginal;
        m[1] = acoTransfer;
        return m;
    }
  
    
    /**
     * opctionTwo is a method to make withdraw in one account number
     * This method has no parameter
     * I read the file and then put the the information in two ArrayList
     * accNum: ArrayList of integers about account numbers
     * acAm: ArrayList of double about the balance in the account
     * Dos is an Account Object and is for the withdraw
     * @throws FileNotFoundException
     * * Also update the file 
     */
    public static void optionTwo() throws FileNotFoundException{
    	String text = "input2.txt";
        File file = new File(text);
        Scanner reader = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (reader.hasNext()) {
            list.add(reader.nextLine());
        }
        reader.close();
        ArrayList<Integer> accNum = new ArrayList<Integer>();
        ArrayList<Double> acAm = new ArrayList<Double>();
        int m = list.size();
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            accNum.add(Integer.parseInt(result[0]));// account number
        }
        
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            acAm.add(Double.parseDouble(result[1]));// account balance
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please input the account number-> ");
        int aconum2 = getAccountNumber(keyboard);
        double balance2 = 0;
        for (int i = 0; i < accNum.size(); i++) {
            if (accNum.get(i).equals(aconum2)) {// compare to match
                balance2 = acAm.get(i);

            }
        }
        System.out.print("Please input the amount-> ");
        double amount2 = getAmount(keyboard);
        Account dos = new Account(aconum2, balance2);
        dos.withdraw(amount2);
        Account[] aco2 = new Account[1];
        aco2[0] = dos;// pass the info to update
        updateAccountDatabase(aco2);
    }
    
    /**
     * opctionThree is a method to make transfer in one account number to another account number.
     * This method has no parameter
     * I read the file and then put the the information in two ArrayList
     * accNum: ArrayList of integers about account numbers
     * acAm: ArrayList of double about the balance in the account
     * Original is an Account Object and  suffer a withdraw.
     * Transfer is Account Object and suffer a deposit from the amount of the original account.
     * @throws FileNotFoundException
     * Also update the file 
     */
    
    public static void OptionThree() throws FileNotFoundException{
    	String text = "input2.txt";
        File file = new File(text);
        Scanner reader = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (reader.hasNext()) {
            list.add(reader.nextLine());
        }
        reader.close();
        ArrayList<Integer> accNum = new ArrayList<Integer>();
        ArrayList<Double> acAm = new ArrayList<Double>();
        int m = list.size();
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            accNum.add(Integer.parseInt(result[0]));
        }
        
        for (int j = 0; j < m; j++) {
            String[] result = list.get(j).split(" ");
            acAm.add(Double.parseDouble(result[1]));
        }
        Scanner keyboard = new Scanner(System.in);
    	
    	int [] accounts = getTransferAccountNumbers(keyboard);
        double balanceOriginal = 0;
        double balanceTransfer = 0;
        System.out.print("Please input the amount-> ");
        double amount3 =getAmount(keyboard);
        for (int i = 0; i < accNum.size(); i++) {
            if (accNum.get(i).equals(accounts[0])) {// compare to match
                balanceOriginal = acAm.get(i);
            }
            if (accNum.get(i).equals(accounts[1])) {// compare to match
                balanceTransfer = acAm.get(i);
            }
        }
        Account original = new Account(accounts[0],balanceOriginal) ;
        Account transfer = new Account(accounts[1],balanceTransfer) ;
        original.withdraw(amount3);
        transfer.deposit(amount3);
        Account [] aco3 = new Account [2];// arrays of objects
        aco3[0]=original;// pass the info to update
        aco3[1]=transfer;// pass the info to update
        updateAccountDatabase(aco3);
    	
    }
   

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	
	private int accNum;
	private String customerName;
	private int customerSSN;
	private double balance;
	private ArrayList<Account> accounts = new ArrayList<>();
	
	private Scanner read;
	private int line = 0;
	private int lineNum = 1;
	
	public Account() {
		this.accNum = 0;
		this.customerName = null;
		this.customerSSN = 0;
		this.balance = 0.0;
	}
	
	public Account(int accNum, String customerName, int customerSSN, double balance) {
		this.accNum = accNum;
		this.customerName = customerName;
		this.customerSSN = customerSSN;
		this.balance = balance;
	}
	
	
	
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", customerName=" + customerName + ", customerSSN=" + customerSSN
				+ ", balance=" + balance + "]\n";
	}
	
	public void printAccounts() {
		for(int i = 0; i < accounts.size(); i++) {
			System.out.println("Account [accNum=" + accounts.get(i).getAccNum() + ", customerName=" + accounts.get(i).getCustomerName() + ", customerSSN=" + accounts.get(i).getCustomerSSN()
				+ ", balance=$" + accounts.get(i).getBalance() + "0]");
		}
	}
	
	public void total() {
		double total = 0.0;
		for(int i = 0; i < accounts.size(); i++) {
			total += accounts.get(i).getBalance();
		}
		System.out.println("Total balance $" + total + "0");
	}

	public void split(String inline) {
		try {
			String[] tokens = inline.split("," , 4);
			customerName = tokens[1].trim();
			accNum = Integer.parseInt(tokens[0].trim());
			customerSSN = Integer.parseInt(tokens[2].trim());
			balance = Double.parseDouble(tokens[3].trim());
			
			Account x = new Account(accNum, customerName, customerSSN, balance);
			
			accounts.add(x);
			
		} catch(NumberFormatException e) {
			line++;
			System.out.println("Bad input line number [" + lineNum + "]: " + inline);
		}
	}
	
	public void openFile() {
		String data = null;
		try {
			File file = new File("account.txt");
			read = new Scanner(file);
			while (read.hasNextLine()) {
		        data = read.nextLine();
		        split(data);
		        lineNum++;
		        //System.out.println(data);
		      }
	      read.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      //e.printStackTrace();
	    }
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerSSN() {
		return customerSSN;
	}

	public void setCustomerSSN(int customerSSN) {
		this.customerSSN = customerSSN;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getSize() {
		return accounts.size();
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
}

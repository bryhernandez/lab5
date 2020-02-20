public class AccountTest{
	
	public static void main(String[] args) {
		Account x = new Account();
		
		x.openFile();
		
		System.out.println("Valid accounts " + x.getSize());
		System.out.println("Invalid accounts "  + x.getLine());
		
		x.printAccounts();
		x.total();
	}
}

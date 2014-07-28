public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankingExample be = new BankingExample();
		be.credit(BankingExample.MAX_BALANCE-1);
		System.out.println("Tester running");
		System.exit(0);
	}

}

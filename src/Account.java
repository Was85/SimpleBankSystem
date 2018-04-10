
public class Account {

	private double balance = 1000.0;

	private String accountNumber;
	
	

	public Account(double balance, String accountNumber) {

		if (balance >= 1000.0) {

			this.balance = balance;
			this.accountNumber = accountNumber;
		} 

		
	}

	public void deposit(double depositValue) {

		if (depositValue > 0) {
			this.balance += depositValue;

			System.out.println(depositValue + " Has been added Seccessfully" + " The new Balance is : " + this.balance);

		} else {
			System.out.println("Invalid Deposit...!");
		}

	}

	public void withdraw(double deductAmount) {

		if (deductAmount >= 0) {

			double currentBalance = this.balance;

			currentBalance = currentBalance - deductAmount;

			if (currentBalance >= 100) {

				Bank bank = new Bank();
				this.balance = this.balance - deductAmount - bank.getTransecFees();
				System.out.println(deductAmount + " Has been withdraw Seccessfully" + " The new Balance is : " + this.balance + ". The Transections fees is :"+ bank.getTransecFees());

			} else {
				System.out.println("Insufficient Balance in Your Account ...");

			}

		} else {

			System.out.println("Please Enter valid amount to withdraw....");

		}

	}

	public double getBalance() {
		return balance;

	}
	
	public String getAccountNumber() {
		return accountNumber;

	}

}

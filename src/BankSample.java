import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class BankSample {

	public static void main(String[] args) throws Exception, IOException {

		String regex = "[a-zA-Z][a-zA-Z ]*" ;
		Bank bank = new Bank();

		ArrayList<Customer> customers = bank.getCustomers();
		customers = new ArrayList<>();

		while (true) {

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\n Please Select your choice : \n ");

			System.out.println("1: New Customer ");
			System.out.println("2: Deposit...");
			System.out.println("3: Withdraw..");
			System.out.println("4: Check Balance");
			System.out.println("5: Calculate Interest ");
			System.out.println("6: Exit ...");

			int options = Integer.parseInt(bufferedReader.readLine());

			switch (options) {

			case 1:

				System.out.println(" please specifiy The Amount first ?");

				double newCustomerBal = Double.parseDouble(bufferedReader.readLine());
				
				if(newCustomerBal>=1000){
					System.out.println("Please specificy your own account number !!!");

					String accountNumber = bufferedReader.readLine();

					Account account = new Account(newCustomerBal, accountNumber);

					System.out.println("Please Indicate the account that will create under which name ?");

					
					
					String name = bufferedReader.readLine();
					if(name.matches(regex)){
						Customer customer = new Customer(name, account);

						customers.add(customer);

						System.out.println("New Customer has Been Added \n name :  " + customer.getName() + " \n balance :"
								+ customer.getAccount().getBalance() + "\n");	
					}else {
						System.out.println("Please Enter Valid name !");
					}
					
				}else {
					
					System.out.println("Minimum Value For new user is 1000 $");
				}

				
				break;

			case 2:
				
				System.err.println("Please Enter Account Number >>>");
				String accountNumberToAddDeposit = bufferedReader.readLine();

				if (customers.size() == 0) {
					System.out.println("Account number is not Found ! \n ");
				} else{
					boolean accountFound = false;
					for (int i = 0; i < customers.size(); i++) {
						Account tempAccount = customers.get(i).getAccount();
						
						if (tempAccount.getAccountNumber().equals(accountNumberToAddDeposit)) {
							accountFound = true;
							System.out.println("\nPlease Enter The Deposit Amount !");

							double depositAmount = Double.parseDouble(bufferedReader.readLine());

							tempAccount.deposit(depositAmount);

							if (!(accountFound)) {

								System.out.println("\nAccount Number dosnt Exist ...");
							}

						}
						

					}

				}

				break;

			case 3:

				System.err.println("Please Enter Account Number >>>");
				String accountNumberToWithdrawFrom = bufferedReader.readLine();

				if (customers.size() == 0) {
					System.out.println("Account number is not Found ! \n ");
				} else

				{
					boolean accountFound = false;
					for (int i = 0; i < customers.size(); i++) {
						Account tempAccount = customers.get(i).getAccount();
						
						if (tempAccount.getAccountNumber().equals(accountNumberToWithdrawFrom)) {
							System.out.println("Please Enter The Amount which desire to Withdarw !");

							double withdrawAmount = Double.parseDouble(bufferedReader.readLine());

							tempAccount.withdraw(withdrawAmount);

							accountFound = true;

							if (!(accountFound)) {

								System.out.println("Account Number dosnt Exist ...");
							}
						}
						

					}

				}

				break;

			case 4:
				System.err.println("Please Enter Account Number >>>");
				String accountNumberWantToCheckBalance = bufferedReader.readLine();

				if (customers.size() == 0) {
					System.out.println("Account number is not Found ! \n ");
				} else

				{
					boolean accountFound = false;
					for (int i = 0; i < customers.size(); i++) {
						Account tempAccount = customers.get(i).getAccount();
						if (tempAccount.getAccountNumber().equals(accountNumberWantToCheckBalance)) {
								accountFound = true ;
							System.out.println("The Balance is : "+ tempAccount.getBalance());
						}
						if (!(accountFound)) {

							System.out.println("Account Number dosnt Exist ...");
						}
					}
				}

				break;
			case 5:
				System.err.println("Please Enter Account Number >>>");
				String accountNumberWantToCalculateInterest = bufferedReader.readLine();

				if (customers.size() == 0) {
					System.out.println("Account number is not Found ! \n ");
				} else

				{
					boolean accountFound = false;
					for (int i = 0; i < customers.size(); i++) {
						Account tempAccount = customers.get(i).getAccount();
						
						if (tempAccount.getAccountNumber().equals(accountNumberWantToCalculateInterest)) {
								accountFound = true ;

						bank.calculateInterestRate(customers.get(i));
						}
						if (!(accountFound)) {

							System.out.println("Account Number dosnt Exist ...");
						}
					}
				}
				break;

			case 6:

				System.exit(0);

				break;

			default:

				break;

			}

		}

	}

}

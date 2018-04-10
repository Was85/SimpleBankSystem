import java.util.ArrayList;

public class Bank {

	private double interstRate = 5.8 ;
	private double transctionRate = 25 ;
	
	private ArrayList <Customer> customers ;
	
	public void calculateInterestRate (Customer customer) {
		
		Account currentAccunt = customer.getAccount();
		double currentBalance = currentAccunt.getBalance();
		double interstAmount = currentBalance * interstRate/100 ;
		double totalBalance = currentBalance + interstAmount ;
		System.out.println("Interest Amount : "+ interstAmount + "Curretn Account "+ totalBalance);
		
	}
	
	public double getIntersestRate () {
		return interstRate;
		
		
		
	}
	
	
	public ArrayList<Customer> getCustomers (){
		return customers;
		
		
		
	}
	
	public double  getTransecFees(){
		return transctionRate;
		
		
		
	}
	
	
}

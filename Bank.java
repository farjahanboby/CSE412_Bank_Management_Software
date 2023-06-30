package practice.main1;
import java.util.*;

public class Bank {
	
	List<Account> accList = new LinkedList<>();
	
// add account method
	public void addAccount() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please specify the type of account that you want to open (Savings/ Current):");
		String type = in.nextLine();
		
		System.out.println("Please insert the name of the account holder:");
		String name = in.nextLine();
		System.out.println("Please insert the SSN:");
		String ssn = in.nextLine();
		System.out.println("Please insert the initial deposit:");
		double initDeposit = in.nextDouble(); 
		
		if(type.equals("Savings")) {
			accList.add(new Saving(name,ssn,initDeposit));
			Account acc = accList.get(accList.size() - 1);
			acc.showInfo();
		} 
		else if(type.equals("Current")) {
			accList.add(new Current(name,ssn,initDeposit));	
			Account acc = accList.get(accList.size() - 1);
			acc.showInfo();
		}
		else System.out.println("Incorrect selection");
	}
	
// delete account method using the account #
	public void deleteAccount() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please insert the account number to delete:");
		String accNo = in.nextLine();
		
		for(Account a: accList) {
			if(a.getAccNumber().equals(accNo)) {
				accList.remove(a);
				break;
			}
		}
		System.out.println("Account: "+ accNo + " has been deleted");
	}

// deposit funds methods
	public void deposit(String accNo,double amount) {
		for(Account a: accList) {
			if(a.getAccNumber().equals(accNo)) {
				a.setBalance(a.getBalance() + amount);
				System.out.println("Depositing: $" + amount);
				a.printBalance();
			}
		}
	}
	
// withdraw funds method
	public void withdraw(String accNo,double amount) {
		for(Account a: accList) {
			if(a.getAccNumber().equals(accNo)) {
				a.setBalance(a.getBalance() - amount);
				System.out.println("Withdrawing: $" + amount);
				a.printBalance();
			}
		}
	}
// transfer funds method
	public void transfer(String fromWhere, String toWhere, double amount) {
		for (Account a : accList) {
			if (a.getAccNumber().equals(fromWhere)) {
				for (Account b : accList) {
					a.setBalance(a.getBalance() - amount);
					b.setBalance(b.getBalance() + amount);
				}
			}
			System.out.println("Transferring $" + amount + " to " + toWhere);
			a.printBalance();
			break;
		}
	}

   
}


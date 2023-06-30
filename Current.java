package practice.main1;
import java.util.Random;

public class Current extends Account {
	
	private String debitCardNo = "";
	private int debitCardPIN;
	
	public Current (String name, String ssn, double initialDeposit) {
		super(name,ssn,initialDeposit);
		accNumber = "2"+accNumber;
		// set debit card method
		setDebitCard();
	}
	private void setDebitCard() {
		for(int i=0;i<12;i++) {
			Random rand = new Random();
			String value = String.valueOf(rand.nextInt(9));
			debitCardNo = debitCardNo + value;
		}
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4)); //the range of random is 0.0-1.0. thus by default it is float/double.. so to convert it into integer we added int at the begining.
                                                                            // again here digits will be randomly choosen randomly from (0-9999)
	}	
        @Override
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Your Current Account has been created :"+
				"\nDebit Card#: "+ debitCardNo+
				"\nCard PIN: "+ debitCardPIN +
				"\n**************************");
	}
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
}

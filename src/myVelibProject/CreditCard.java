package myVelibProject;

public class CreditCard {
	protected double balance;

	public CreditCard(double balance) {
		super();
		this.balance = balance;
	}
	
	public void charge(double amount) throws GeneralException {
		if (balance >amount) {balance -= amount;}
		else throw new GeneralException("Balance Insufficient");
	}

	
	

}

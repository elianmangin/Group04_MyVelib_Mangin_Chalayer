package myVelibProject;

public class Card {
	protected User user;
	protected int balance;
	protected String type;
	protected CostStrategy strategy;
	protected CostFactory costFactory = new CostFactory();
	
	public Card(User user) {
		super();
		this.user = user;
		this.type = null;
		this.balance = 0;
		this.strategy = costFactory.create(null);
	}
	
	public Card(User user, String type) {
		super();
		this.user = user;
		this.type = type;
		this.balance = 0;
		this.strategy = costFactory.create(type);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public String getType() {
		return type;
	}
	
	public CostStrategy getStrategy() {
		return strategy;
	}

	@Override
	public String toString() {
		return type + " Card owned by " + user.getName() + " (" + user.getUniqID() + "). TimeCredit : " + balance;
	}
	
	public void addCredit(int amount) {
		this.balance += amount;
	}
	
	public void removeCredit(int amount) {
		this.balance -= amount;
	}
	
	
	
	
	
	

}

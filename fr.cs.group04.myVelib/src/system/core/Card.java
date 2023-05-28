package system.core;

/**
 * This class defines the characteristics of a registration card.
 * <p>
 * A registration card is own by a user and is used to know how to compute the cost of a ride and
 * to store the user's time credit.
 * </p>
 */
public class Card {
	protected User user;
	protected int balance;
	protected String type;
	protected CostStrategy strategy;
	protected CostFactory costFactory = new CostFactory();

	/** Creates a registration card with no type associated to a given user. This card represent the fact that the user does
	 * not own a registration card. It is used only to compute the cost of a ride and cannot be used to store time credit.*/
	public Card(User user) throws GeneralException {
		super();
		this.user = user;
		this.type = null;
		this.balance = 0;
		this.strategy = costFactory.create(null);
	}

	/** Creates a registration card with a given type associated to a given user.*/
	public Card(User user, String type) throws GeneralException {
		super();
		this.user = user;
		this.type = type;
		this.balance = 0;
		this.strategy = costFactory.create(type);
	}

	/** Add time credit of a given amount to the time credit balance.*/
	public void addCredit(int amount) throws GeneralException{
		if(amount <0) throw new GeneralException();
		this.balance += amount;
	}

	/** Remove time credit of a given amount to the time credit balance.*/
	public void removeCredit(int amount) throws GeneralException{
		if((amount < 0) || (amount > balance)) throw new GeneralException();
		this.balance -= amount;
	}


	// Getters, Setters, toString
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









}

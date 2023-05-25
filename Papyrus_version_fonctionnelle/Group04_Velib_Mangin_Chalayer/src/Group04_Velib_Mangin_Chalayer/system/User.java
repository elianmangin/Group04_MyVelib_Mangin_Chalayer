package Group04_Velib_Mangin_Chalayer.system;

public class User {
	protected String name;
	protected static int idCounterUser = 0;
	protected int uniqID;
	protected Coordinates gps;
	protected UserBalance balance;
	protected double creditBalance;
	protected Card registrationCard; 
	protected Ride currentRide;
	

	public User(String name, Coordinates gps, String cardType, double initialBalance) throws GeneralException {
		super();
		idCounterUser++;
		this.uniqID = idCounterUser;
		this.name = name;
		this.gps = gps;
		this.balance = new UserBalance();
		this.creditBalance = initialBalance;
		this.registrationCard = new Card(this, cardType);
		this.currentRide = null;
	}
	
	public void charge(double amount) throws GeneralException {
		if (amount<0) throw new GeneralException();
		if (creditBalance >amount) {creditBalance -= amount;}
		else throw new GeneralException("Balance Insufficient");
	}
	
	public boolean isCurrentlyRenting() {
		if (this.currentRide == null) {return true;}
		else {return false;}
	}
	
	
	// Getters, Setters, toString
	public Coordinates getGps() {
		return gps;
	}

	public void setGps(Coordinates gps) {
		this.gps = gps;
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	public void setCurrentRide(Ride ride) {
		this.currentRide = ride;
	}
	
	public Ride getCurrentRide() {
		return currentRide;
	}

	public String getName() {
		return name;
	}

	public int getUniqID() {
		return uniqID;
	}

	public UserBalance getBalance() {
		return balance;
	}

	public Card getRegistrationCard() {
		return registrationCard;
	}

	@Override
	public String toString() {
		return "\n\n" + name + " ID " + uniqID + "\nCurrent position : " + gps + "\n" + balance
				+ "\n---\nCredit : " + creditBalance + " euros\nRegistration Card : " + registrationCard + "\nCurrently on ride : "
				+ this.isCurrentlyRenting();
	}

	public static void setIdCounterUser(int idCounterUser) {
		User.idCounterUser = idCounterUser;
	}






}

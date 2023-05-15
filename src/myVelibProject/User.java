package myVelibProject;

import java.util.ArrayList;

public class User {
	protected String name;
	protected static int idCounterUser;
	protected int uniqIDUser;
	protected Coordinates coordinatesUser;
	protected String registrationCard; //vMax or vLibre
	protected CreditCard creditCard;
	protected UserBalance balance;
	protected ArrayList<Ride> RideList;
	protected boolean currentlyRenting;
	protected int timeCredit;
	protected RideStart ridestart;
	
	public User(String name, Coordinates coordinatesUser, String registrationCard, CreditCard creditCard) {
		super();
		this.name = name;
		this.coordinatesUser = coordinatesUser;
		this.registrationCard = registrationCard;
		this.creditCard = creditCard;
		idCounterUser++;
		uniqIDUser = idCounterUser;
		balance = new UserBalance();
		RideList = new ArrayList<Ride>();
		currentlyRenting = false;
		timeCredit = 0;
		ridestart = null;
	}
	
	public void addTimeCredit(int addedTimeCredit) {
		timeCredit = timeCredit +addedTimeCredit;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", uniqIDUser=" + uniqIDUser + ", coordinatesUser=" + coordinatesUser
				+ ", registrationCard=" + registrationCard + ", creditCard=" + creditCard + ", currentlyRenting="
				+ currentlyRenting + "]";
	}
	public int getTimeCredit() {
		return timeCredit;
	}
	public void setTimeCredit(int timeCredit) {
		this.timeCredit = timeCredit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUniqIDUser() {
		return uniqIDUser;
	}
	public void setUniqIDUser(int uniqIDUser) {
		this.uniqIDUser = uniqIDUser;
	}
	public Coordinates getCoordinatesUser() {
		return coordinatesUser;
	}
	public void setCoordinatesUser(Coordinates coordinatesUser) {
		this.coordinatesUser = coordinatesUser;
	}
	public String getRegistrationCard() {
		return registrationCard;
	}
	public void setRegistrationCard(String registrationCard) {
		this.registrationCard = registrationCard;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public boolean isCurrentlyRenting() {
		return currentlyRenting;
	}
	public void setCurrentlyRenting(boolean currentlyRenting) {
		this.currentlyRenting = currentlyRenting;
	}
	public UserBalance getBalance() {
		return balance;
	}
	public void setBalance(UserBalance balance) {
		this.balance = balance;
	}
	public ArrayList<Ride> getRideList() {
		return RideList;
	}
	public void setRideList(ArrayList<Ride> rideList) {
		RideList = rideList;
	}
	
}

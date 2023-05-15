package myVelibProject;

public class Coordinates {
	protected double latitude;
	protected double longitude;
	
	public Coordinates(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	@Override
	public String toString() {
		return "["+ latitude + ", " + longitude + "]";
	}
	
}

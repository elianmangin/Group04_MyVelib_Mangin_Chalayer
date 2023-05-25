package Group04_MyVelib_Mangin_Chalayer.system.core;

/**
 * Represents GPS coordinates
 * <p>
 * Coordinates are x and y in km.
 * </p>
 */
public class Coordinates {
	protected double x;
	protected double y;

	/** Creates a Coordinates object with given (x, y).*/
	public Coordinates(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/** Return true if given coordinates are equals to this coordinates.*/
	public boolean equals(Coordinates c) {
		if (this.x == c.x && this.y == c.y) {
			return true;
		}
		else {
			return false;
		}
	}

	/** Return the distance between given coordinates and this coordinates.*/
	public double distance(Coordinates c) {
		return Math.sqrt(Math.pow(x - c.x, 2)+Math.pow(y - c.y, 2));
	}


	// Getters, Setters, toString
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "["+ x + ", " + y + "]";
	}



}

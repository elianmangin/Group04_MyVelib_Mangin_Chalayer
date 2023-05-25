package Group04_Velib_Mangin_Chalayer.system;

public class Coordinates {
	protected double x;
	protected double y;
	
	public Coordinates(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Coordinates c) {
		if (this.x == c.x && this.y == c.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
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

package myVelibProject;
import java.util.Comparator;

public class ComparatorByDistanceStation implements Comparator<DockingStation>{
	protected Coordinates coordinates;
	
	public ComparatorByDistanceStation(Coordinates coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public double distanceBetween(Coordinates coord1,Coordinates coord2) {
		return Math.sqrt(Math.pow(coord1.getLatitude()-coord2.getLatitude(),2)+Math.pow(coord1.getLongitude()-coord2.getLongitude(),2));
	}
	
	@Override
	public int compare(DockingStation o1, DockingStation o2) {
		 
		double distance1 =  distanceBetween(coordinates,o1.getCoordinatesStation());
		double distance2 =  distanceBetween(coordinates,o2.getCoordinatesStation());
		
		if (distance1>distance2) {return 1;}
		if (distance1<distance2) {return -1;}
		else{return 0;}
	}
}
